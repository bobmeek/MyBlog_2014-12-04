/**  
 * @Title: MyBlogT.java
 * @Package org.myblog.test
 * @Description: TODO
 * @author bobmeek
 * @date Dec 4, 2014 10:26:58 PM
 * @version V1.0  
 */
package com.myblog.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.myblog.model.CategoryVO;

/**
 * @ClassName: MyBlogT
 * @Description: TODO
 * @author bobmeek
 * @date Dec 4, 2014 10:26:58 PM
 */
public class MyBlogT
{
	public static void main(String[] args)
	{
		// 与configuration.xml中的mapper配置类似，告诉MyBatis
		// 应读取的核心配置文件
		/*String resource = "org/myblog/resources/config/configuration.xml";
		Reader reader = null;
		try
		{
			reader = Resources.getResourceAsReader(resource);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		// 创建SqlSessionFactory实例。没有指定要用到的
		// environment，则使用默认的environment
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try
		{
			ICategoryDao mapper = sqlSession.getMapper(ICategoryDao.class);
			List<CategoryVO> allCategoryVOs = mapper.list();
			if (allCategoryVOs != null)
			{
				System.out.println("条数："+allCategoryVOs.size()+"=="+allCategoryVOs.get(0).getName());
			}
			else
			{
				System.out.println("没有找到。");
			}
		}
		finally
		{
			sqlSession.close();
		}*/
	}
}
