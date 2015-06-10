package org.myblog.controller;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.myblog.common.SortListUtil;
import org.myblog.model.ArticleVO;
import org.myblog.model.IndexImageVO;
import org.myblog.model.MenuVO;
import org.myblog.model.SiteInfoVO;
import org.myblog.service.facade.ArticleService;
import org.myblog.service.facade.CategoryService;
import org.myblog.service.facade.IndexImageService;
import org.myblog.service.facade.MenuService;
import org.myblog.service.facade.SiteInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

/**   
 * @desc   [ 首页的业务逻辑控制 ]
 * @author [ bobmeek ]   
 * @time   [ 2015年3月20日 下午3:08:03 ] 
 *
 */
@Controller
@Service
public class IndexController {
		
	@Resource(name = "articleServiceImpl")
	private ArticleService articleService;
	
	@Resource(name = "siteInfoServiceImpl")
	private SiteInfoService siteInfoService;
	@Resource(name = "categoryServiceImpl")
	private CategoryService categoryService;
	@Resource(name = "menuServiceImpl")
	private MenuService menuService;
	@Resource(name="indexImageServiceImpl")
	private IndexImageService indexImageService;
	
	
	@RequestMapping(value="index.html")
	public String showIndex(HttpServletRequest request,HttpSession session,ModelMap modelMap){
		
		findInfo(request,session,modelMap);
		return "index";
		
	}
	
	
	/**
	 * 
	 * @desc   [ 获取菜单信息/首页图片信息/系统配置信息 ]
	 * @param  [ @param request
	 * @param  [ @param session
	 * @param  [ @param modelMap
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015-5-26 下午12:20:40 ] 
	 *
	 */
	@SuppressWarnings("unchecked")
	public ModelMap findInfo(HttpServletRequest request,HttpSession session,ModelMap modelMap){
		//获取网站信息
		SiteInfoVO siteInfo = siteInfoService.findAll().get(0);
		//获取所有菜单 - 导航菜单/栏目菜单
		List<MenuVO> menus = menuService.findAll();
		
		menus = (List<MenuVO>) SortListUtil.sort(menus, "orders", SortListUtil.DESC);
		
		//LinkedHashMap - 先进先出  
		//一级菜单-二级菜单/二级菜单/二级子菜单 , 一对多的关系
		Map<String,List<String>> navMenuMap = new LinkedHashMap<String,List<String>>();
		
		//首页栏目组合Map 一对多关系(一个栏目,多篇文章)
		Map<String,List<ArticleVO>> categoryMenuMap = new LinkedHashMap<String,List<ArticleVO>>();
		Map<MenuVO,List<ArticleVO>> categoryMenuMapTemp = new TreeMap<MenuVO,List<ArticleVO>>(new Comparator<MenuVO>() {
			@Override
			public int compare(MenuVO m1, MenuVO m2) {
				return new Integer(m1.getOrders()).compareTo(new Integer(m2.getOrders())); 
				
			}
		});
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
			}else if(m.getType()==1 && m.getStatus()==1){
				List<ArticleVO> articles = articleService.findListByMenuId(m.getId());
				if(null!=articles && articles.size()>0){
					articles = (List<ArticleVO>) SortListUtil.sort(articles, "id",SortListUtil.DESC);
				}
				categoryMenuMapTemp.put(m, articles);
				
				
			}
		}
		
		Set<Entry<MenuVO, List<ArticleVO>>> entryCategory = categoryMenuMapTemp.entrySet();
		for (Entry<MenuVO, List<ArticleVO>> entry : entryCategory) {
			categoryMenuMap.put(entry.getKey().getName(), entry.getValue());
		}
		//获取首页宣传图片
		List<IndexImageVO> indexImgs = indexImageService.findAll();
		//打开文章的方式:本窗口?新窗口
		String target = siteInfo.getTarget();
		modelMap.addAttribute("siteInfo",siteInfo);
		modelMap.addAttribute("navMenuMap",navMenuMap);
		modelMap.addAttribute("categoryMenuMap",categoryMenuMap);
		modelMap.addAttribute("indexImgs",indexImgs);
		
		
		return modelMap;
		
		
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
	/*@RequestMapping(value="currentPage/{currentPage}")
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
	}*/
	
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
