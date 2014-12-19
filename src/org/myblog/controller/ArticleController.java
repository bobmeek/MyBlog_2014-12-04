/**  
 * @Title: ArticleController.java
 * @Package org.myblog.controller
 * @Description: TODO
 * @author bobmeek
 * @date Dec 18, 2014 11:51:26 AM
 * @version V1.0  
 */
package org.myblog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.myblog.model.ArticleVO;
import org.myblog.service.facade.IArticleService;
import org.myblog.service.impls.ArticleServiceImpls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: ArticleController
 * @Description: TODO
 * @author bobmeek
 * @date Dec 18, 2014 11:51:26 AM
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController
{
	@Autowired
	private IArticleService articleService;
	@RequestMapping(value="/showArticles",method=RequestMethod.POST)
	public String showArticles(String name,String pass,HttpSession session)
	{
		List<ArticleVO> articles = articleService.getAllArticles();
		System.out.println("文章的篇数："+articles.size());
		for (ArticleVO articleVO : articles)
		{
			System.out.println("文章名称："+articleVO.getTitle()+"==文章内容:"+articleVO.getContent());
		}
		session.setAttribute("name", name);
		session.setAttribute("pass", pass);
		session.setAttribute("articles", articles);
		return "index";
	}
	
	
	
	
	
	
	
	
	
	public IArticleService getArticleService()
	{
		return articleService;
	}
	public void setArticleService(IArticleService articleService)
	{
		this.articleService = articleService;
	}
	
}
