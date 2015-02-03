package org.myblog.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.myblog.common.Pager;
import org.myblog.model.TagVO;
import org.myblog.service.facade.ArticleTagService;
import org.myblog.service.facade.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TagController 
{	
	@Resource(name = "tagServiceImpl")
	private TagService tagService;
	
	@Resource(name = "articleTagServiceImpl")
	private ArticleTagService articleTagService;
	
	
	/**
	 * 添加标签
	 * @param article_tag
	 * @return
	 */
	@RequestMapping(value="tag/addTag.do", produces="application/text;charset=UTF-8")
	@ResponseBody
	public String addTag(String article_tag)
	{
		TagVO tag = new TagVO();
		tag.setName(article_tag);
		
		tagService.addTag(tag);

		//return "redirect:../tag/showArticleTag.do";
		return "标签添加成功！";
	}
	
	/**
	 * 分类查询全部标签
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="tag/showArticleTag.do")
	public String showArticleTag(HttpServletRequest request, ModelMap model)
	{
		List<TagVO> tags = tagService.findAll();
		model.addAttribute("tag", tags);
		
		return "article/showTag";
	}
	
	/**
	 * 删除指定标签
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="tag/deleteArticleTag.do")
	public String deleteArticleTag(HttpServletRequest request, ModelMap model, Integer id)
	{
		articleTagService.delete(id); //先删除article_tag id
		tagService.delete(id); //后删除tag id
		
		return "redirect:../tag/showArticleTag.do";
	}
	
	@RequestMapping(value="tag/tag_list.do")
	public String taglist(HttpServletRequest request, ModelMap model)
	{
		int pageSize = 5; //定义分页显示的文章数目
		int pageNo = 0; //定义页码
		
		String u_pageNo = request.getParameter("pager.offset"); //获得用户点击的页码
		
		if(u_pageNo != null)
		{
			pageNo = Integer.parseInt(u_pageNo);
		}
		
		Pager<TagVO> tagPager =  tagService.findByPage(pageNo, pageSize);
		model.addAttribute("tag", tagPager.getPageList());
		model.addAttribute("tag2", tagPager);
		
		return "article/showTag";
	}
	
	/**
	 * 根据指定搜索条件显示标签信息
	 * @param request
	 * @param model
	 * @param searchTag
	 * @return
	 */
	@RequestMapping(value="tag/searchArticleTag.do", produces="application/text;charset=UTF-8")
	@ResponseBody
	public String searchArticleTag(HttpServletRequest request, ModelMap model, String searchTag)
	{
		List<TagVO> tags =  tagService.searchTags(searchTag);
		model.addAttribute("tag", tags);
		
		return "搜索中";
		//return "redirect:../tag/showArticleTag.do";
	}
	
	/**
	 * 标签批量删除
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="tag/bulkdeleteTag.do")
	public String bulkdeleteArticleTag(HttpServletRequest request, ModelMap model, int[] id)
	{
		List<Integer> list = new ArrayList<Integer>();
			
		for(int i = 0; i < id.length; i++)
		{
			list.add(id[i]); //将获得的每一个id值添加到集合容器
		}
		System.out.println("list id = " + list);
		System.out.println("list size = " + list.size());
		
		tagService.bulk_delete2(list); //先批量删除文章标签
		tagService.bulk_delete(list); //后标签删除标签
		
		return "redirect:../tag/showArticleTag.do";
	}
}