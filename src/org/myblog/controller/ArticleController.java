 package org.myblog.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.myblog.common.DateUtil;
import org.myblog.common.Pager;
import org.myblog.common.page.Page;
import org.myblog.common.page.PageUtil;
import org.myblog.dto.ImgDTO;
import org.myblog.model.ArticleVO;
import org.myblog.model.MenuVO;
import org.myblog.service.facade.ArticleService;
import org.myblog.service.facade.ArticleTagService;
import org.myblog.service.facade.CategoryService;
import org.myblog.service.facade.MenuService;
import org.myblog.service.facade.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;

@Controller
@RequestMapping("/article/")
public class ArticleController
{
	@Resource(name = "articleServiceImpl")
	private ArticleService articleService;
	
	@Resource(name = "categoryServiceImpl")
	private CategoryService categoryService;
	
	@Resource(name = "tagServiceImpl")
	private TagService tagService;
	
	@Resource(name = "articleTagServiceImpl")
	private ArticleTagService articleTagService;

	@Resource(name = "menuServiceImpl")
	private MenuService menuService;
	
	@RequestMapping(value = "save")
	@ResponseBody
	public int saveArticle(ArticleVO article){
		articleService.save(article);
		return 1;
	}
	
	@RequestMapping(value = "update")
	@ResponseBody
	public int updateArticle(ArticleVO article){
		articleService.update(article);
		return 1;
	}
	
	
	@RequestMapping(value="show/category")
	@ResponseBody
	public List<MenuVO> showCategory(){
		List<MenuVO> menus = menuService.findAll();
		
		return menus;
	}
	

	@RequestMapping(value="show/allArticles", produces="application/json")
	@ResponseBody
	public ModelMap showAllArticlesByPager(int currentPage,int menuId,ModelMap modelMap)
	{
		
		int pageCount = 5;
		int totalCount = 0;
		if(menuId==1000000)
			totalCount = articleService.getTotalNum();
		else
			totalCount = articleService.getTotalNumByMenuId(menuId);
		Page page = PageUtil.createPage(pageCount, currentPage, totalCount);
		int totalPage = page.getTotalPage();
		currentPage = page.getCurrentPage();
		int startIndex = page.getSrartIndex();
		boolean hasPrePage = page.isHasPrePage();
		boolean hasNextPage = page.isHasNextPage(); 
		
		Pager<ArticleVO> pagers = null; 
		if(menuId==1000000)		
			pagers = articleService.findByPage(startIndex, pageCount);
		else
			pagers = articleService.findPageByMenuId(menuId, startIndex, pageCount);
		
		List<ArticleVO> articles = pagers.getPageList();
		
		modelMap.addAttribute("articles",articles);
		modelMap.addAttribute("totalCount",totalCount);
		modelMap.addAttribute("totalPage",totalPage);
		modelMap.addAttribute("currentPage",currentPage);
		modelMap.addAttribute("hasPrePage",hasPrePage);
		modelMap.addAttribute("hasNextPage",hasNextPage);
		
		return modelMap;
	}
	
	
	
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
	
	
	@RequestMapping(value="upload/img",produces="application/json;charset=utf-8")
	public String uploadImage(String articleName,MultipartHttpServletRequest mRequest, HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		MultipartFile patch = mRequest.getFile("fileData");
		System.out.println(request.getContextPath());
		//获取文件
		String fileFallName = patch.getOriginalFilename();
		//获取文件名
		String fileName = FilenameUtils.getBaseName(fileFallName);
		//获取文件扩展名
		String fileExt = FilenameUtils.getExtension(fileFallName);
		//要上传的文件,格式为: 文件名_当前时间戳.文件类型
		fileFallName = fileName+"_"+System.currentTimeMillis()+"."+fileExt;
		String path = "";
		if(!patch.isEmpty())
		{
			path = request.getSession().getServletContext().getRealPath("resources\\upload\\img\\article\\"+DateUtil.getYear()+"\\"+DateUtil.getMonth()+"\\"+DateUtil.getDay()+"\\"+articleName);
			File destFile = new File(path); // 设置目标文件路径
			if(!destFile.exists())
			{
				// 如果文件不存在则新建一个文件夹
				destFile.mkdirs();
			}
			
			patch.transferTo(new File(destFile.getAbsolutePath() + "\\" + fileFallName));
			out.flush();
		}
		
		//path = path.replace("\\", "\\/");
		path = request.getContextPath()+"\\resources\\upload\\img\\article\\"+DateUtil.getYear()+"\\"+DateUtil.getMonth()+"\\"+DateUtil.getDay()+"\\"+articleName;
		ImgDTO img = new ImgDTO();
		img.setFileName(fileFallName);
		img.setFile_path(path+"\\"+fileFallName);
		img.setSuccess("true");
		Gson gson = new Gson();
		String msg = gson.toJson(img);
		
	    out.print(msg); //返回msg信息    
		return null;
	}
	
	
	
	
	
	
	
}