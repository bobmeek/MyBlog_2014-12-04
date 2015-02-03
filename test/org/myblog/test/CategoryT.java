/*package org.myblog.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.myblog.model.CategoryVO;
import org.myblog.service.facade.CategoryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CategoryT 
{
	private static CategoryService categoryService;

	@BeforeClass
	public static void setUpBeforeClass() 
	{
		ApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext.xml");
		
		categoryService = (CategoryService)context.getBean("categoryServiceImpl");
	}
	
	@Test
	public void test()
	{
		CategoryVO category = new CategoryVO();
		category.setName("test_category1");
		
		categoryService.addCategory2(category, 2);
	}
}
*/