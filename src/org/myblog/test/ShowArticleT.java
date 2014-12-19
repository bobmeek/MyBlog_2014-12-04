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

import org.myblog.controller.ArticleController;
import org.myblog.controller.CategoryController;
import org.myblog.model.CategoryVO;
import org.myblog.service.facade.ICategoryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @ClassName: MyBlogSpringT
 * @Description: TODO
 * @author bobmeek
 * @date Dec 5, 2014 6:27:53 AM
 */
public class ShowArticleT
{
	private static ApplicationContext ctx;
	static
	{
	
		ctx = new ClassPathXmlApplicationContext("org/myblog/resources/config/applicationContext.xml");
//		ctx = new FileSystemXmlApplicationContext("WebRoot/WEB-INF/config/applicationContext.xml");		
		
		
	}

	//1.搭建通用框架(Dao,Service)
	//2.将配置文件配到WebRoot.
	//3.SpringMVC
	public static void main(String[] args)
	{
		ArticleController article = (ArticleController) ctx.getBean("articleController");
		
		article.showArticles("aa", "bb",null);
		// 使用StringBuilder的append操作代替字符串的“+”
		// 操作可提高执行效率
		
	}
}
