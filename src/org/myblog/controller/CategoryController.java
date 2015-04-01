package org.myblog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.myblog.common.SortListUtil;
import org.myblog.model.CategoryVO;
import org.myblog.service.facade.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/category/")
public class CategoryController
{
	@Resource(name =  "categoryServiceImpl")
	private CategoryService categoryService;

	//登录
	//加个HttpSession就会把session注入进来,
	//加HttpServletRequest,request也会被注入
	@RequestMapping(value="/index",method=RequestMethod.POST)
	public String login(String name,String pass,HttpSession session)
	{
		session.setAttribute("name", name);
		session.setAttribute("pass", pass);
		System.out.println("name:"+name+"---pass:"+pass);
		return "index";
	}
	
	/**
	 *  获取栏目信息
	 * @param request
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/show")
	@ResponseBody
	public List<CategoryVO> showCategory(HttpServletRequest request, ModelMap modelMap)
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
	public void update(CategoryVO category){
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
	public void add(CategoryVO category){
		int maxOrders = categoryService.findMaxOrders();
		category.setOrders(maxOrders+1);
		categoryService.addCategory(category);
	}
	
	@RequestMapping(value = "/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable Integer id){
		categoryService.delete(id);
	}
	
	
	
	
	/**
	 * 添加栏目名称
	 * @param category_name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/add1", produces="application/json")
	@ResponseBody
	public ModelMap addCategoryName(ModelMap modelMap, String category_name) throws Exception
	{
		/*System.out.println("addCategoryName invoked!!!");
		System.out.println("addCategoryName category_name = " + category_name);*/
		
		CategoryVO category = new CategoryVO();
		category.setName(category_name); //添加栏目名称
		
		categoryService.addCategory(category);
		modelMap.addAttribute("c_cid", category.getId());
		
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
		/*System.out.println("showArticleByCategory invoked!!!");
		System.out.println("showArticleByCategory categoryid = " + categoryid);*/
		
		List<CategoryVO>  categorys =  categoryService.findArticleByCategoryId(categoryid);
		
		//System.out.println("article size = " + articles.size());
		
		for(int i = 0; i < categorys.size(); i++)
		{
			System.out.println("article i = "  + categorys.get(i));
		}
		modelMap.addAttribute("categorys", categorys);
		
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
	

}