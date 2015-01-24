/**  
 * @Title: UsersT.java
 * @Package org.myblog.test
 * @Description: TODO
 * @author bobmeek
 * @date Dec 24, 2014 8:25:15 PM
 * @version V1.0  
 */
package org.myblog.test;

import java.util.List;
import org.myblog.controller.ArticleController;
import org.myblog.model.UserVO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: UsersT
 * @Description: TODO
 * @author bobmeek
 * @date Dec 24, 2014 8:25:15 PM
 */
public class UsersT
{
	private static ApplicationContext ctx;
	static
	{
	
		ctx = new ClassPathXmlApplicationContext("org/myblog/resources/config/applicationContext.xml");
		
	}
	
		public static void main(String[] args)
		{
			
//			IUsersService usersService = (IUsersService)ctx.getBean("usersService");
//			List<UsersVO> users = usersService.getAllUsers();
//			for (UsersVO usersVO : users)
//			{
//				System.out.println("用户名： "+usersVO.getUsername());
//				System.out.println("邮箱： "+usersVO.getMail());
//			}
			
			
			UserVO u = new UserVO();
			u.setUsername("b");
			u.setUserpwd("aa");
			
//			usersService.addUser(u);
			
		}
}
