/*package org.myblog.test;

import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.myblog.model.ArticleVO;
import org.myblog.service.facade.ArticleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArticleT
{
	private static ArticleService articleService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		ApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext.xml");
		
		articleService = (ArticleService)context.getBean("articleServiceImpl");
	}
	
	*//**
	 * 查询全部文章信息
	 *//*
	@Test
	public  void test1()
	{
		List<ArticleVO> articles = articleService.findAll(); //查询全部Article对象返回一个List集合
		
		for(ArticleVO article : articles)
		{
			System.out.println("文章序列：" + article.getId());
			System.out.println("文章标题：" + article.getTitle());
			System.out.println("文章作者：" + article.getAuthor());
			System.out.println("分类目录：" + article.getCategory().getName());
			System.out.println("文章标签：" + article.getTag().getName());
			System.out.println("发布时间：" + article.getReleaseDate());
		}
	}
	
	*//**
	 * 根据文章id删除文章信息
	 *//*
	@Test
	public void test2()
	{
		ArticleVO article = articleService.findById(1); //根据文章id返回一个Article对象
		System.out.println(article);
		
		//articleService.delete(6);
	}
	
	*//**
	 * 根据输入的参数模糊查询集合文章信息
	 *//*
	@Test
	public void test3()
	{
		List<ArticleVO> articles = articleService.searchArticles("JavaScript");
		
		for(ArticleVO article : articles)
		{
			System.out.println(article.getId());
			System.out.println(article.getTitle());
			System.out.println(article.getAuthor());
			System.out.println(article.getTag().getName());
		}
	}
}*/