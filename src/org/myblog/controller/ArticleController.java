 package org.myblog.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.myblog.common.DateUtil;
import org.myblog.common.Pager;
import org.myblog.dto.ImgDTO;
import org.myblog.model.ArticleTagVO;
import org.myblog.model.ArticleVO;
import org.myblog.model.CategoryVO;
import org.myblog.model.MenuVO;
import org.myblog.model.TagVO;
import org.myblog.service.facade.ArticleService;
import org.myblog.service.facade.ArticleTagService;
import org.myblog.service.facade.CategoryService;
import org.myblog.service.facade.MenuService;
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
	
	
	@RequestMapping(value="show/category")
	@ResponseBody
	public List<MenuVO> showCategory(){
		List<MenuVO> menus = menuService.findAll();
		
		return menus;
	}
	
	@RequestMapping(value="{articleId}/{articleName}")
	public String showArticle(@PathVariable int articleId,ModelMap modelMap){
		ArticleVO article = articleService.findById(articleId);
		modelMap.put("article", article);
		return "articleInfo";
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