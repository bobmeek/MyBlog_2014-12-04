package org.myblog.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.myblog.common.DateUtil;
import org.myblog.common.SortListUtil;
import org.myblog.model.CategoryVO;
import org.myblog.service.facade.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/category/")
public class CategoryController
{
	@Resource(name =  "categoryServiceImpl")
	private CategoryService categoryService;

	
	/**
	 * 添加栏目名称
	 * @param category_name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/add1")
	@ResponseBody
	public ModelMap addCategoryName(ModelMap modelMap, String category_name) throws Exception
	{
		/*System.out.println("addCategoryName invoked!!!");
		System.out.println("addCategoryName category_name = " + category_name);*/
		
		CategoryVO category = new CategoryVO();
		//category.setId(category.getId());
		category.setName(category_name); //添加栏目名称
		category.setAdjunctionDate(DateUtil.convertTimestamp("yyyy-MM-dd HH:mm", new Date()));
		
		categoryService.addCategory(category);
		modelMap.addAttribute("c_cid", category.getId());
		modelMap.addAttribute("category_name", category_name);
		
		return modelMap;
	}
	
	@RequestMapping(value="/updateCategory")
	@ResponseBody
	public ModelMap updateCategory(ModelMap modelMap, int category_id,  String category_name) throws Exception
	{
		CategoryVO category = new CategoryVO();
		
		category.setId(category_id);
		category.setName(category_name);
		
		categoryService.update(category);
		
		return modelMap;
	}
	
	/**
	 *  获取栏目信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/showCategory")
	@ResponseBody
	public ModelMap showCategory(HttpServletRequest request, ModelMap modelMap)
	{
		System.out.println("showCategory invoked!!!");
		
		List<CategoryVO> categorys =  categoryService.findAll();
		modelMap.addAttribute("categorys", categorys);
		
		return modelMap;
	}

	
	/**
	 * 通过栏目id查询相关文章信息
	 * @param categoryid：文章id
	 * @return
	 */
	@RequestMapping(value="/showArticleByCid")
	@ResponseBody
	public ModelMap showArticleByCategory(ModelMap modelMap, int categoryid)
	{
		System.out.println("showArticleByCategory invoked!!!");
		System.out.println("showArticleByCategory categoryid = " + categoryid);
		
		List<CategoryVO>  categorys =  categoryService.findArticleByCategoryId(categoryid);
		
		//System.out.println("article size = " + articles.size());
		int artidFirstId = 0;
		String articleFirstContent = "";
		for(int i = 0; i < categorys.size(); i++)
		{
			System.out.println("article i = "  + categorys.get(i));
			//System.out.println("article id[0] = " + categorys.get(0).getArticles().get(0).getId());
			artidFirstId = categorys.get(0).getArticles().get(0).getId();
			articleFirstContent =  categorys.get(0).getArticles().get(0).getContent(); 
		}
		modelMap.addAttribute("categorys", categorys);
		modelMap.addAttribute("artidFirstId", artidFirstId);
		modelMap.addAttribute("articleFirstContent", articleFirstContent);
		
		return modelMap;
	}
	
	/**
	 * 添加栏目
	 * @param request
	 * @param model
	 * @param category
	 * @return
	 */
	@RequestMapping(value="category/addCategory.do")
	public String addCategory(HttpServletRequest request, ModelMap model, CategoryVO category)
	{
		
		System.out.println("category name: " + category.getName());
		System.out.println("category parent_id: " + category.getParentId());
		
		Integer pid = category.getParentId();
		
		if(pid == 0)
		{
			pid = null;
		}
		
		category.setParentId(pid);
		categoryService.save(category); //保存栏目对象
		
		return "redirect:../category/showCategory.do";
	}
	
	
	/************************************************************导航栏目*************************************************************************/
	
	
	/**
	 * 
	 * @desc   [ 获取栏目信息 ]
	 * @param  [ @param request
	 * @param  [ @param modelMap
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年4月1日 下午5:07:37 ] 
	 *
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/show")
	@ResponseBody
	public List<CategoryVO> showNavCategory(HttpServletRequest request, ModelMap modelMap)
	{
		
		List<CategoryVO> categorys =  categoryService.findNavigate(1);
		//按照orders排序
		categorys = (List<CategoryVO>) SortListUtil.sort(categorys, "orders", SortListUtil.ASC);
		modelMap.addAttribute("categorys", categorys);
		
		return categorys;
	}
	
	
	
	
	/**
	 * 
	 * @desc   [ 更新栏目信息 ]
	 * @param  [ @param category ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月31日 下午6:15:32 ] 
	 *
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public void updateNavCategory(CategoryVO category){
		categoryService.update(category);
	}
	
	/**
	 * 
	 * @desc   [ 添加栏目 ]
	 * @param  [ @param category ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月31日 下午11:11:31 ] 
	 *
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public void addNavCategory(CategoryVO category){
		//获取type为1(导航栏目)的最大orders
		int maxOrders = categoryService.findMaxOrders(1);
		category.setOrders(maxOrders+1);
		categoryService.addCategory(category);
	}
	
	@RequestMapping(value = "/delete/{id}")
	@ResponseBody
	public void deleteNavCategory(@PathVariable Integer id){
		categoryService.delete(id);
	}
	
	

}