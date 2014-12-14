/**  
 * @Title: MyBlogSpringT.java
 * @Package org.myblog.test
 * @Description: TODO
 * @author bobmeek
 * @date Dec 5, 2014 6:27:53 AM
 * @version V1.0  
 */
package org.myblog.test;

import java.util.List;

import org.myblog.model.CategoryVO;
import org.myblog.service.facade.ICategoryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: MyBlogSpringT
 * @Description: TODO
 * @author bobmeek
 * @date Dec 5, 2014 6:27:53 AM
 */
public class MyBlogSpringT
{
	private static ApplicationContext ctx;
	static
	{
	
		ctx = new ClassPathXmlApplicationContext("org/myblog/resources/config/applicationContext.xml");
		
	}

	//1.搭建通用框架(Dao,Service)
	//2.将配置文件配到WebRoot.
	//3.SpringMVC
	public static void main(String[] args)
	{
		ICategoryService categoryService = (ICategoryService) ctx.getBean("categoryService");
		
		List<CategoryVO> allCategoryVOs = categoryService.getAllCategories();
		// 使用StringBuilder的append操作代替字符串的“+”
		// 操作可提高执行效率
		System.out.println("数目:"+allCategoryVOs.size());
	}
}
