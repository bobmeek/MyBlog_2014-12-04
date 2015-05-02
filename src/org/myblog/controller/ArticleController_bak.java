 package org.myblog.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.myblog.common.DateUtil;
import org.myblog.common.Pager;
import org.myblog.model.ArticleTagVO;
import org.myblog.model.ArticleVO;
import org.myblog.model.CategoryVO;
import org.myblog.model.TagVO;
import org.myblog.service.facade.ArticleService;
import org.myblog.service.facade.ArticleTagService;
import org.myblog.service.facade.CategoryService;
import org.myblog.service.facade.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/article/")
public class ArticleController_bak
{
	@Resource(name = "articleServiceImpl")
	private ArticleService articleService;
	
	@Resource(name = "categoryServiceImpl")
	private CategoryService categoryService;
	
	@Resource(name = "tagServiceImpl")
	private TagService tagService;
	
	@Resource(name = "articleTagServiceImpl")
	private ArticleTagService articleTagService;
	
	
	
	
	
	/**
	 * 分页显示文章信息列表
	 * @param model
	 * @param pageNo：定义页码 (文章从第几条开始显示)
	 * @param pageSize：定义文章显示数目
	 * @return
	 */
	@RequestMapping(value="show/allArticles.do", produces="application/json")
	@ResponseBody
	public ModelMap showAllArticlesByPager(ModelMap modelMap, int pageNo, int pageSize)
	{
		/*System.out.println("showAllArticlesByPager invoked!!!");
		System.out.println("showAllArticlesByPager pageNo: " + pageNo);
		System.out.println("showAllArticlesByPager pageSize: " + pageSize);*/
		
		Pager<ArticleVO> articlePager =  articleService.findByPage(pageNo, pageSize);
		modelMap.addAttribute("articlePager", articlePager);

		return modelMap;
	}
	
	/**
	 * 删除文章
	 * @param id：文章id
	 * @return
	 */
	@RequestMapping(value="delete/{id}", produces="application/json")
	@ResponseBody
	public int deleteArticle(@PathVariable int id) //注解@PathVariable标记为请求路径变量--Restful风格
	//因为隐藏了参数与路径的关系，可以提升网站的安全性，静态化页面，降低恶意攻击风险
	{
		System.out.println("deleteArticle invoked!!!");
		System.out.println("deleteArticle id: " + id);
		
		articleService.delete(id);
		
		return 1;
	}
	
	/**
	 * 批量删除文章
	 * @param arr：数组arr用以接收多个文章id
	 * @return
	 */
	@RequestMapping(value="/delete/idArr", produces="application/json")
	@ResponseBody
	public int deleteArticleBatch(@RequestBody int[] arr) //该注解用于读取request请求的body部分数据，最终返回的数据会绑定到方法参数上
	{
		/*System.out.println("deleteArticleBatch invoked!!!");
		System.out.println("deleteArticleBatch arr length = " + arr.length);*/
		
		List<Integer> ids = new ArrayList<Integer>();
		
		for(int i = 0; i < arr.length; i++) //循环得到前台传递的id值
		{
			ids.add(arr[i]); //将获得的每一个id值添加到集合容器
		}
		
		articleService.bulk_delete2(ids); //文章标签删除
		articleService.bulk_delete(ids); //文章批量删除
		
		return 1;
	}
	
	/**
	 * 搜索文章
	 * @param modelMap
	 * @param article_text：搜索关键字
	 * @return
	 */
	@RequestMapping(value="/search/searchArticle", produces="application/json")
	@ResponseBody
	public ModelMap searchArticle(ModelMap modelMap, String article_text)
	{
		/*System.out.println("searchArticle invoked!!!");
		System.out.println("searchArticle article_text = " + article_text);*/
		
		List<ArticleVO> articles = articleService.searchArticles(article_text);
		modelMap.addAttribute("articles", articles);
		
		return modelMap;
	}
	
	
	/**
	 * 通过文章id查询相关文章信息
	 * @param modelMap
	 * @param article_id：文章id
	 * @return
	 */
	@RequestMapping(value="/showArticleByAid")
	@ResponseBody
	public ModelMap showArticleByArticleId(ModelMap modelMap, int article_id)
	{
		/*System.out.println("showArticleByArticleId invoked!!!");
		System.out.println("showArticleByArticleId id = " + article_id);*/
		
		ArticleVO article =  articleService.findById(article_id);
		modelMap.addAttribute("article", article);
		
		return modelMap;
	}
	
	/**
	 *	保存文章 
	 * @throws Exception 
	 */
	@RequestMapping(value="/saveArticle", produces="application/json")
	@ResponseBody
	public ModelMap saveArticle(ModelMap modelMap, String title, int id_category) throws Exception
	{
		System.out.println("saveArticle invoked!!!");
		System.out.println("saveArticle title = " + title + "  , category = " + id_category);
		
		ArticleVO article = new ArticleVO();
		article.setTitle(title);
		article.setCagegoryId(id_category);
		//article.setReleaseDate(DateUtil.convertTimestamp("yyyy-MM-dd HH:mm", new Date()));
		
		articleService.addArticle(article);
		
		modelMap.addAttribute("save_articleid", article.getId()); //返回保存文章的id
		
		return modelMap;
	}
	
	/**
	 * 修改文章
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/updateArticle", produces="application/json")
	@ResponseBody
	//public int updateArticle(ArticleVO article) throws Exception
	public int updateArticle(String title, String content, int id) throws Exception
	{
		ArticleVO article = new ArticleVO();
		article.setTitle(title);
		article.setContent(content);
		article.setId(id);
		//article.setReleaseDate(DateUtil.convertTimestamp("yyyy-MM-dd HH:mm", new Date()));
		
		System.out.println("updateArticle invoked!!!");
		System.out.println("updateArticle article = " + article);

		articleService.update(article);	

		return 1;
	}
	
	@RequestMapping(value="/publishArticle")
	public String publishedArticle()
	{
		/*ArticleVO article = new ArticleVO();
		article.setTitle(article_title);
		article.setContent(article_content);
		article.setId_category(id_category);
		article.setReleaseDate(DateUtil.convertTimestamp("yyyy-MM-dd HH:mm", new Date()));
		
		articleService.addArticle(article);*/
		System.out.println("publishedArticle invoked!!!");
		
		return "redirect:../show/allArticles.do";
	}
	
	/**
	 * 上传图片
	 * @param mRequest
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 * @throws IOException
	 */
	@RequestMapping(value="/upload")
	public String addd(MultipartHttpServletRequest mRequest, HttpServletRequest request, HttpServletResponse response,  ModelMap model) throws Exception, IOException
	{
		 response.setContentType("text/html; charset=UTF-8");
		 
		 PrintWriter out = response.getWriter();
		
		MultipartFile patch = mRequest.getFile("fileData");
		
		String fileName = patch.getOriginalFilename(); // 得到文件名称
		
		if(!patch.isEmpty())
		{
			String path = request.getSession().getServletContext().getRealPath("/resources/upload/img/article");
			//System.out.println("path ==== " + path);
			File destFile = new File(path); // 设置目标文件路径
			//System.out.println("destFile === "  + destFile.getAbsolutePath()+ "\\" + fileName);
			if(!destFile.exists())
			{
				// 如果文件不存在则新建一个文件夹
				destFile.mkdirs();
			}
			
			patch.transferTo(new File(destFile.getAbsolutePath() + "\\" + fileName));
			out.flush();
		}
		
		return null;
		
	}
}