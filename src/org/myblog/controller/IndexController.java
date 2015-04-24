package org.myblog.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.myblog.common.Pager;
import org.myblog.common.SortListUtil;
import org.myblog.common.page.Page;
import org.myblog.common.page.PageUtil;
import org.myblog.model.ArticleVO;
import org.myblog.model.CategoryVO;
import org.myblog.model.MenuVO;
import org.myblog.model.SiteInfoVO;
import org.myblog.service.facade.ArticleService;
import org.myblog.service.facade.CategoryService;
import org.myblog.service.facade.MenuService;
import org.myblog.service.facade.SiteInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.xml.internal.ws.api.pipe.NextAction;

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
	private static SiteInfoVO siteInfo = null;
	//每页显示文章数量
	private static int pageCount = 0;
	//显示热门文章数量
	private static int hotPageCount = 0;
	//打开文章的方式:本窗口?新窗口
	private static String target = "";
	@SuppressWarnings("unchecked")
	@RequestMapping(value="index.html")
	public String showIndex(HttpServletRequest request,ModelMap modelMap){
		//获取网站信息
		siteInfo = siteInfoService.findAll().get(0);
		//获取导航栏目
		List<MenuVO> menus = menuService.findAll();
		menus = (List<MenuVO>) SortListUtil.sort(menus, "orders", SortListUtil.ASC);
		
		Map<String,List<String>> menuMap = new HashMap<String,List<String>>();
		
		
		for (MenuVO m : menus) {
			if(m.getParentId()==1){
				List<String> manyMenus = new ArrayList<String>();
				for (MenuVO mv : menus) {
					if(m.getId()==mv.getParentId()){
						manyMenus.add(mv.getName());
					}
				}
				menuMap.put(m.getName(), manyMenus);
			}
		}
		
		
		
		pageCount = siteInfo.getPageCount();
		hotPageCount = siteInfo.getHotPageCount();
		target = siteInfo.getTarget();
		//获取文章信息
		//modelMap = showArticles(1, modelMap);
		modelMap.addAttribute("siteInfo",siteInfo);
		modelMap.addAttribute("menus",menus);
		modelMap.addAttribute("menuMap",menuMap);
		return "index";
	}
	
	//使用ArrayList实现一个Key对应一个ArrayList实现一对多
//    public static void putAdd(Map<String,List<MenuVO>> menuMap,String sr,String[] s){
//        if(!menuMap.containsKey(sr)){
//        	menuMap.put(sr, new ArrayList<String>());
//        }
//        for(int i=0;i<s.length;i++){
//        	menuMap.get(sr).add(s[i]);
//        }
//    }
	
	
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
	public ModelMap showArticles(int currentPage,ModelMap modelMap){
		int totalCount = articleService.getTotalNum();
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
	
	@RequestMapping(value="{id}")
	public String showArticle(@PathVariable int id,ModelMap modelMap){
		ArticleVO article = articleService.findById(id);
		siteInfo = siteInfoService.findAll().get(0);
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
	}
	
}
