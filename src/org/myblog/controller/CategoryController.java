/**  
 * @Title: CategoryController.java
 * @Package org.myblog.controller.CatrgoryController
 * @Description: TODO
 * @author bobmeek
 * @date Dec 6, 2014 2:55:11 PM
 * @version V1.0  
 */
package org.myblog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName: CategoryController
 * @Description: TODO
 * @author bobmeek
 * @date Dec 6, 2014 2:55:11 PM
 */
@Controller
public class CategoryController
{
	
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

}
