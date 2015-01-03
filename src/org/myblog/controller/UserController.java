/**  
 * @Title: LoginControllerr.java
 * @Package org.myblog.controller
 * @Description: TODO
 * @author bobmeek
 * @date Dec 14, 2014 10:52:40 AM
 * @version V1.0  
 */
package org.myblog.controller;


import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.myblog.common.EmailUtils;
import org.myblog.common.MD5;
import org.myblog.model.UserVO;
import org.myblog.service.facade.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: LoginControllerr
 * @Description: TODO
 * @author bobmeek
 * @date Dec 14, 2014 10:52:40 AM
 */
@Controller
@RequestMapping("/user/")
public class UserController
{

	@Resource(name = "userServiceImpl")
	private UserService userService;

	
	/**
	 * @Description 校验该用户或者邮箱是否已存在
	 * @author bobmeek
	 * @Title existProp
	 * @param @param attr 用户名?邮箱
	 * @param @param value 校验值
	 * @param @param session
	 * @param @return
	 * @return String 返回类型
	 */
	@ResponseBody
	@RequestMapping(value = "/checked.do", produces = "application/json")
	public boolean isExist(String attr, String value) throws Exception
	{
		boolean flag = false;
		int count = 0;
		if (attr.equals("username"))
		{
			count = userService.nameIsExist(value);
		}
		else
		{
			count = userService.mailIsExist(value);
		}

		if (count > 0)
			flag = true;
		return flag;

	}
	
	
	
	
	/**
	 * @Description 添加用户  
	 * @author bobmeek
	 * @Title add 
	 * @param @param request
	 * @param @param model
	 * @param @param user
	 * @param @return
	 * @return String    返回类型
	 */
	@ResponseBody
	@RequestMapping(value = "/add.do",produces = "application/json")
	public UserVO add(HttpServletRequest request, String username,String userpwd,String mail)
	{	
		
		
		UserVO user = new UserVO();
//		Timestamp birthdayTime = Timestamp.valueOf(birthday);
		user.setUsername(username);
		user.setMail(mail);
//		user.setBirthday(birthdayTime);
//		user.setSex(sex);
//		
		// 对密码进行MD5加密  + 盐值
		user.setUserpwd(MD5.MD5Encode(username,userpwd));
		user.setMailActive(0);
		// 发送激活邮件
		EmailUtils.sendAccountActivateEmail(user);
		
		//保存用户
		userService.saveUser(user);
		
		return user; 
	}
		
	@RequestMapping(value="/activeMail.do")
	public String activeMail(String mail,String checkCode)
	{
		UserVO user = userService.findByMail(mail);
		System.out.println("user:"+user);
		user.setMailActive(1);
		userService.update(user);
		System.out.println("激活成功======mail:"+mail+"==checkCode:"+checkCode+"======激活成功");
		return "redirect:../article/showArticles";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
