package org.myblog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.myblog.common.SortListUtil;
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
		modelMap.put("programName", "");
		return "categoryArticleInfo";
	}
	
	
	/**获取栏目菜单的文章列表**/
	@SuppressWarnings("unchecked")
	@RequestMapping(value="{categoryMenuName}/{currentPage}")
	public String showArticleList(@PathVariable String categoryMenuName,@PathVariable int currentPage,HttpServletRequest request,HttpSession session,ModelMap modelMap){
		modelMap = indexController.findInfo(request, session, modelMap);
		MenuVO menu = menuService.findByName(categoryMenuName);
		int pageCount = 5;
		int totalCount = articleService.getTotalNumByMenuId(menu.getId());
		Page page = PageUtil.createPage(pageCount, currentPage, totalCount);
		List<ArticleVO> articles = articleService.findPageByMenuId(menu.getId(), page.getSrartIndex(), pageCount).getPageList();
		//根据置顶与发布时间共同排序 , 优先级:置顶>发布时间
		articles = (List<ArticleVO>) SortListUtil.sort(articles,new String[]{"topLevel","releaseDate"},new String[]{SortListUtil.DESC,SortListUtil.DESC});
		modelMap.put("totalCount", totalCount);
		modelMap.put("totalPage", page.getTotalPage());
		modelMap.put("articles", articles);
		modelMap.put("categoryMenuName", categoryMenuName);
		modelMap.put("programName", "");
		return "categoryArticleList";
	}
	
}
