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
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.myblog.model.ArticleVO;
import org.myblog.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: ArticleController
 * @Description: TODO
 * @author bobmeek
 * @date Dec 18, 2014 11:51:26 AM
 */
@Controller
public class ArticleController
{
	@Resource(name = "articleServiceImpls")
	private ArticleService articleService;
	
	@RequestMapping("/article/showArticles")
	public String showArticles(String name, String pass, HttpSession session)
	{
		System.out.println("1111111111111111111");
		List<ArticleVO> articles = articleService.findAll();
		
		System.out.println("文章的篇数：" + articles.size());
		
		for (ArticleVO articleVO : articles)
		{
			System.out.println("文章名称：" + articleVO.getTitle() + "==文章内容：" + articleVO.getContent());
		}
		
		session.setAttribute("name", name);
		session.setAttribute("pass", pass);
		session.setAttribute("articles", articles);
		System.out.println("22222222222222222222222");
		return "index";
	}
	
	/**
	 * 最新文章下文章内容的显示
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/new_articles")
	public String list(HttpServletRequest request, ModelMap model, Integer id)
	{
		/*ArticleVO articleVO = articleService.findById(id);
		model.addAttribute("article", articleVO);*/
		
		return "index";
	}
}