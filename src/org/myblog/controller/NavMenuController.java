package org.myblog.controller;

import java.util.ArrayList;
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
@RequestMapping(value="/nav/")
public class NavMenuController {
	
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
	
	
	/**点击一级菜单**/
	@RequestMapping(value = "{menuName}/{currentPage}")
	public String showMenus(@PathVariable String menuName,@PathVariable int currentPage,HttpServletRequest request,HttpSession session,ModelMap modelMap){
		return redirectURL(menuName, menuName,currentPage, request,session, modelMap);
	}
	 
	/**点击二级菜单**/
	@RequestMapping(value = "{menuName}/{childMenuName}/{currentPage}")
	public String showMenus(@PathVariable String menuName,@PathVariable String childMenuName,@PathVariable int currentPage,HttpServletRequest request,HttpSession session,ModelMap modelMap){
		return redirectURL(menuName, childMenuName,currentPage, request,session, modelMap);
	}
	
	
	
	/**根据所点击的导航菜单获取该菜单以及其子菜单的所有信息,并返回到导航菜单简介/导航菜单列表**/
	@SuppressWarnings("unchecked")
	public String redirectURL(String menuName,String childMenuName,int currentPage,HttpServletRequest request,HttpSession session,ModelMap modelMap){
		modelMap = indexController.findInfo(request, session, modelMap);
		String redirectURL = "";
		MenuVO menu = null;
		ArticleVO article = null;
		List<MenuVO> menus = null;
		session.setAttribute("parentMenuName", menuName);
		session.setAttribute("childMenuName", childMenuName);
		modelMap.put("parentMenuName", menuName);
		modelMap.put("childMenuName", childMenuName);
		modelMap.put("programName", childMenuName);
		if(!"".equals(childMenuName) && null!=childMenuName && !menuName.equals(childMenuName)){
			menu = menuService.findByName(childMenuName);
			if(null!=menu){
				menus = menuService.findListByParentId(menu.getParentId());
			}
		}else{
			menu = menuService.findByName(menuName);
			if(null!=menu){
				menus = menuService.findListByParentId(menu.getId());
			}
		}
		
		if(null!=menus){
			menus = null!=menus && menus.size()>0?(List<MenuVO>) SortListUtil.sort(menus, "orders",SortListUtil.ASC):null;
			int pageCount = 5;
			int totalCount = articleService.getTotalNumByMenuId(menu.getId());
			Page page = PageUtil.createPage(pageCount, currentPage, totalCount);
			List<ArticleVO> articles = articleService.findPageByMenuId(menu.getId(), page.getSrartIndex(), pageCount).getPageList();
			
			//将公开文章放到一个中介集合中,再赋值给原集合
			List<ArticleVO> articlesTemp = new ArrayList<ArticleVO>();
			for (int i = 0; i < articles.size(); i++) {
				if(articles.get(i).getPrivacy()==1){
					articlesTemp.add(articles.get(i));
				}
			}
			articles = articlesTemp;
			
			if(null!=articles && articles.size()>0){
				articles = (List<ArticleVO>) SortListUtil.sort(articles, "releaseDate",SortListUtil.ASC);
				int totalPage = page.getTotalPage();
				modelMap.put("totalCount", totalCount);
				modelMap.put("currentPage", currentPage);
				modelMap.put("totalPage", totalPage);
				
				
				article = articles.get(0);
			}
			redirectURL = articles.size()>1?"navArticleList":"navArticleSummary";
			session.setAttribute("menus", menus);
			modelMap.put("menus", menus);
			modelMap.put("articles", articles);
			modelMap.put("article", article);
		}
		return redirectURL;
	}
	
	/**获取导航菜单的文章内容**/
	@SuppressWarnings("unchecked")
	@RequestMapping(value="{childMenuName}/{currentPage}/{articleId}/{articleTitle}")
	public String showArticle(@PathVariable int articleId,HttpServletRequest request,HttpSession session,ModelMap modelMap){
		modelMap = indexController.findInfo(request, session, modelMap);
		ArticleVO article = articleService.findById(articleId);
		modelMap.put("article", article);
		modelMap.put("parentMenuName", (String) session.getAttribute("parentMenuName"));
		modelMap.put("childMenuName", (String) session.getAttribute("childMenuName"));
		modelMap.put("menus", (List<MenuVO>) session.getAttribute("menus"));
		modelMap.put("programName", (String)session.getAttribute("childMenuName"));
		return "navArticleInfo";
	}
	
}
