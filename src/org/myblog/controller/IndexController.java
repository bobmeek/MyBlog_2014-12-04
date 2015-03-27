package org.myblog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.myblog.common.Pager;
import org.myblog.common.SortListUtil;
import org.myblog.common.page.Page;
import org.myblog.common.page.PageUtil;
import org.myblog.model.ArticleVO;
import org.myblog.model.SiteInfoVO;
import org.myblog.service.facade.ArticleService;
import org.myblog.service.facade.SiteInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	
	private static int pageCount = 0;
	private static int hotPageCount = 0;
	
	@RequestMapping(value="index.html")
	public String showIndex(HttpServletRequest request,ModelMap modelMap){
		//获取网站信息
		SiteInfoVO siteInfo = siteInfoService.findAll().get(0);
		pageCount = siteInfo.getPageCount();
		hotPageCount = siteInfo.getHotPageCount();
		//获取文章信息
		modelMap = showArticles(1, modelMap);
		modelMap.addAttribute("siteInfo",siteInfo);
		return "index";
	}
	
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
		Pager<ArticleVO> hotPagerArticles = articleService.findByPage(startIndex, hotPageCount);
		List<ArticleVO> articles = pagerArticles.getPageList();
		@SuppressWarnings("unchecked")
		//按照阅读次数对热门文章排序
		List<ArticleVO> hotArticles = (List<ArticleVO>) SortListUtil.sort(hotPagerArticles.getPageList(), "readCount", SortListUtil.DESC);
		modelMap.put("hasPrePage", hasPrePage);
		modelMap.put("hasNextPage", hasNextPage);
		modelMap.put("totalPage", totalPage);
		modelMap.put("pageCount", pageCount);
		modelMap.put("currentPage", currentPage);
		modelMap.put("articles", articles);
		modelMap.addAttribute("hotArticles",hotArticles);
		return modelMap;
	}
	
	
	
}
