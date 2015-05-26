package org.myblog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.myblog.common.page.Page;
import org.myblog.common.page.PageUtil;
import org.myblog.model.ArticleVO;
import org.myblog.model.MenuVO;
import org.myblog.service.facade.ArticleService;
import org.myblog.service.facade.CategoryService;
import org.myblog.service.facade.MenuService;
import org.myblog.service.facade.SiteInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/category/")
public class CategorMenuController {
	
	
	@Resource(name = "articleServiceImpl")
	private ArticleService articleService;
	
	@Resource(name = "siteInfoServiceImpl")
	private SiteInfoService siteInfoService;
	@Resource(name = "categoryServiceImpl")
	private CategoryService categoryService;
	@Resource(name = "menuServiceImpl")
	private MenuService menuService;
	@Resource(name = "indexController")
	private IndexController indexController;
	
	/**获取栏目菜单的文章内容**/
	@RequestMapping(value="{categoryMenuName}/{articleId}/{articleTitle}")
	public String showArticle(@PathVariable String categoryMenuName,@PathVariable int articleId,HttpServletRequest request,HttpSession session,ModelMap modelMap){
		modelMap = indexController.findInfo(request, session, modelMap);
		ArticleVO article = articleService.findById(articleId);
		modelMap.put("categoryMenuName", categoryMenuName);
		modelMap.put("article", article);
		return "categoryArticleInfo";
	}
	
	
	/**获取栏目菜单的文章列表**/
	@RequestMapping(value="{categoryMenuName}/{currentPage}")
	public String showArticleList(@PathVariable String categoryMenuName,@PathVariable int currentPage,HttpServletRequest request,HttpSession session,ModelMap modelMap){
		modelMap = indexController.findInfo(request, session, modelMap);
		MenuVO menu = menuService.findByName(categoryMenuName);
//		List<ArticleVO> articles = articleService.findListByMenuId(menu.getId());
		int pageCount = 5;
		int totalCount = articleService.getTotalNumByMenuId(menu.getId());
		Page page = PageUtil.createPage(pageCount, currentPage, totalCount);
		List<ArticleVO> articles = articleService.findPageByMenuId(menu.getId(), page.getSrartIndex(), pageCount).getPageList();
		modelMap.put("totalCount", totalCount);
		modelMap.put("totalPage", page.getTotalPage());
		modelMap.put("articles", articles);
		modelMap.put("categoryMenuName", categoryMenuName);
		return "categoryArticleList";
	}
	
}
