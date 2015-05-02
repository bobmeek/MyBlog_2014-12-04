package org.myblog.controller;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.myblog.common.BaseUtils;
import org.myblog.common.Pager;
import org.myblog.common.SortListUtil;
import org.myblog.common.page.Page;
import org.myblog.common.page.PageUtil;
import org.myblog.model.ArticleVO;
import org.myblog.model.MenuVO;
import org.myblog.model.SiteInfoVO;
import org.myblog.service.facade.ArticleService;
import org.myblog.service.facade.CategoryService;
import org.myblog.service.facade.MenuService;
import org.myblog.service.facade.SiteInfoService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * @desc   [ 首页的业务逻辑控制 ]
 * @author [ bobmeek ]   
 * @time   [ 2015年3月20日 下午3:08:03 ] 
 *
 */
@Controller
public class IndexController {
		
	@Resource(name = "articleServiceImpl")
	private ArticleService articleService;
	
	@Resource(name = "siteInfoServiceImpl")
	private SiteInfoService siteInfoService;
	@Resource(name = "categoryServiceImpl")
	private CategoryService categoryService;
	@Resource(name = "menuServiceImpl")
	private MenuService menuService;
	@SuppressWarnings("unchecked")
	@RequestMapping(value="index.html")
	public String showIndex(HttpServletRequest request,HttpSession session,ModelMap modelMap){
		//获取网站信息
		SiteInfoVO siteInfo = siteInfoService.findAll().get(0);
		//获取所有菜单 - 导航菜单/栏目菜单
		List<MenuVO> menus = menuService.findAll();
		menus = (List<MenuVO>) SortListUtil.sort(menus, "orders", SortListUtil.DESC);
		
		//LinkedHashMap - 先进先出  
		//一级菜单-二级菜单/二级菜单/二级子菜单 , 一对多的关系
		Map<String,List<String>> navMenuMap = new LinkedHashMap<String,List<String>>();
		
		
		for (MenuVO m : menus) {
			//如果父ID为1,那么该菜单属于一级菜单
			if(m.getType()==0 && m.getParentId()==1 && m.getStatus()==1){
				//存储二级菜单的集合 - 利用LinkedList
				LinkedList<String> manyMenus = new LinkedList<String>();
				for (MenuVO mv : menus) {
					//若该菜单的父ID为一级菜单的ID,那么该菜单为二级菜单,将该菜单添加到集合中
					if(mv.getType()==0 && mv.getParentId()==m.getId() && mv.getStatus()==1){
						manyMenus.addFirst(mv.getName()); //先进后出
					}
				}
				
				//key为一级菜单,value为二级菜单集合
				if(navMenuMap.size()<=siteInfo.getNavCount())
					navMenuMap.put(m.getName(), manyMenus);
			}
		}
		
		
		//每页显示文章数量
		int pageCount = siteInfo.getPageCount();
		//显示热门文章数量
		int hotPageCount = siteInfo.getHotPageCount();
		//打开文章的方式:本窗口?新窗口
		String target = siteInfo.getTarget();
		session.setAttribute("pageCount", pageCount);
		session.setAttribute("hotPageCount", hotPageCount);
		session.setAttribute("target", target);
		session.setAttribute("siteInfo", siteInfo);
		session.setAttribute("navMenuMap", navMenuMap);
		
		//获取文章信息
		//modelMap = showArticles(1, modelMap);
		modelMap.addAttribute("siteInfo",siteInfo);
		//modelMap.addAttribute("menus",menus);
		modelMap.addAttribute("navMenuMap",navMenuMap);
		return "index";
	}
	
	
	@RequestMapping(value = "menu/{menuName}/")
	public String showMenuInfo(@PathVariable String menuName,HttpSession session,ModelMap modelMap){
		MenuVO menu = menuService.findByName(menuName);
		if(null!=menu){
			List<MenuVO> menus = menuService.findListByParentId(menu.getId());
			List<ArticleVO> articles = articleService.findListByMenuId(menu.getId());
			modelMap.put("menus", menus);
			modelMap.put("articles", articles);
		}
		return "menuInfo";
	}
	
	@RequestMapping(value = {"menu/{menuName}/{childMenuName}"})
	public String showMenuInfo(@PathVariable String menuName,@PathVariable String childMenuName,HttpSession session,ModelMap modelMap){
		if(!"".equals(childMenuName) && null!=childMenuName)
			menuName = childMenuName;
		MenuVO menu = menuService.findByName(menuName);
		if(null!=menu){
			List<MenuVO> menus = menuService.findListByParentId(menu.getParentId());
			List<ArticleVO> articles = articleService.findListByMenuId(menu.getId());
			modelMap.put("menus", menus);
			modelMap.put("articles", articles);
		}
		return "menuInfo";
	}
	
	
	/**
	 * 
	 * @desc   [ 显示文章 ]
	 * @param  [ @param currentPage 当前页
	 * @param  [ @param modelMap 
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月27日 下午5:49:43 ] 
	 *
	 */
	@RequestMapping(value="currentPage/{currentPage}")
	@ResponseBody
	public ModelMap showArticles(int currentPage,HttpSession session,ModelMap modelMap){
		int totalCount = articleService.getTotalNum();
		int pageCount = (Integer) session.getAttribute("pageCount");
		int hotPageCount = (Integer) session.getAttribute("hotPageCount");
		String target = (String) session.getAttribute("target");
		
		//每页显示条数/当前页/总条数
		Page page = PageUtil.createPage(pageCount, currentPage, totalCount);
		int totalPage = page.getTotalPage();
		int startIndex = page.getSrartIndex();
		boolean hasPrePage = page.isHasPrePage();
		boolean hasNextPage = page.isHasNextPage(); 
		Pager<ArticleVO> pagerArticles = articleService.findByPage(startIndex, pageCount);
		List<ArticleVO> hotPagerArticles = articleService.findAll();
		List<ArticleVO> articles = pagerArticles.getPageList();
		@SuppressWarnings("unchecked")
		//按照阅读次数对热门文章排序
		List<ArticleVO> hotArticles = (List<ArticleVO>) SortListUtil.sort(hotPagerArticles, "readCount", SortListUtil.DESC);
		modelMap.put("hasPrePage", hasPrePage);
		modelMap.put("hasNextPage", hasNextPage);
		modelMap.put("totalPage", totalPage);
		modelMap.put("pageCount", pageCount);
		modelMap.put("currentPage", currentPage);
		modelMap.put("target", target);
		modelMap.put("articles", articles);
		modelMap.put("hotPageCount", hotPageCount);
		modelMap.addAttribute("hotArticles",hotArticles);
		
		return modelMap;
	}
	
	/*@SuppressWarnings("unchecked")
	@RequestMapping(value="{id}")
	public String showArticle(@PathVariable int id,HttpSession session, ModelMap modelMap){
		int hotPageCount = (Integer) session.getAttribute("hotPageCount");
		ArticleVO article = articleService.findById(id);
		SiteInfoVO siteInfo = siteInfoService.findAll().get(0);
		//获取导航栏目
		List<CategoryVO> categorys =  categoryService.findNavigate(1);
		categorys = (List<CategoryVO>) SortListUtil.sort(categorys, "orders", SortListUtil.ASC);
		List<ArticleVO> hotPagerArticles = articleService.findAll();
		@SuppressWarnings("unchecked")
		//按照阅读次数对热门文章排序
		List<ArticleVO> hotArticles = (List<ArticleVO>) SortListUtil.sort(hotPagerArticles, "readCount", SortListUtil.DESC);
		modelMap.put("article", article);
		modelMap.put("siteInfo", siteInfo);
		modelMap.put("hotPageCount", hotPageCount);
		modelMap.put("hotArticles", hotArticles);
		modelMap.put("categorys", categorys);
		return "showArticles";
	}*/
	
}
