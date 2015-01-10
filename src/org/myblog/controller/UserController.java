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
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.myblog.common.CommonUtils;
import org.myblog.common.DateUtil;
import org.myblog.common.EmailUtil;
import org.myblog.common.MD5;
import org.myblog.model.UserExtVO;
import org.myblog.model.UserVO;
import org.myblog.service.facade.UserExtService;
import org.myblog.service.facade.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	@Resource(name = "userExtServiceImpl")
	private UserExtService userExtService;

	
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
			count = userService.emailIsExist(value);
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
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value = "/add.do",produces = "application/json")
	public UserVO add(HttpServletRequest request, UserVO user) throws Exception
	{	
		user.setRegisterTime(DateUtil.convertTimestamp(new Date()));
		user.setRegisterIP(CommonUtils.getPublidIp());
		user.setIsEmailActive(0);
		user.setIsDisabled(1);
		
		// 对密码进行MD5加密  + 盐值
		user.setUserpwd(MD5.MD5Encode(user.getUsername(),user.getUserpwd()));
		// 发送激活邮件
		EmailUtil.sendAccountActivateEmail(user);
		
		//保存用户基本信息
		userService.saveUser(user);
		
		//保存用户扩展信息
		UserExtVO userExtVO = new UserExtVO();
		userExtVO.setUser(user);
		userExtService.save(userExtVO);
		
		return user; 
	}
		
	
	@RequestMapping(value="/activeMail.do")
	public String activeMail(String mail,String checkCode)
	{
		UserVO user = userService.findByMail(mail);
		user.setIsEmailActive(1);
		userService.update(user);
		System.out.println("激活成功======mail:"+mail+"==checkCode:"+checkCode+"======激活成功");
		return "redirect:../article/showArticles";
	}
	
	@ResponseBody
	@RequestMapping(value="/login.do",produces="application/json")
	public int login(String attr,String userpwd) throws Exception
	{
		
		UserVO user = userService.findByMail(attr);
		//如果得到空对象，证明是用用户名登录，否则是用邮箱登录
		if(null==user)  
		{
			userpwd = MD5.MD5Encode(attr,userpwd);
			user = userService.findByUsername(attr);
		}
		else
		{
			userpwd = MD5.MD5Encode(user.getUsername(), userpwd);
		}
		
		if(userService.nameIsExist(attr)>0 || userService.emailIsExist(attr)>0)
		{
			//用户名登录
			if(userService.nameLogin(attr, userpwd)>0 || userService.emailLogin(attr, userpwd)>0)
			{
				
				user.setLastLoginTime(DateUtil.convertTimestamp(new Date()));
				user.setLastLoginIP(CommonUtils.getPublidIp());
				userService.update(user);
				//正确
				return 1;
			}
			else
			{ 
				//密码错误
				return 0;
			}
		}
		else
		{
			//没有该用户
			return -1;
		}
	}
	
	
	@RequestMapping(value="/test.do",produces="application/json;charest=utf-8")
    @ResponseBody 
	public UserExtVO showUserDatilInfo()
	{
		UserExtVO userDatilInfo = userExtService.findDetailInfoById(2);
		return userDatilInfo;
	}
	
	 
//    @RequestMapping(value="/test.do",produces="application/json;charest=utf-8")
//    @ResponseBody
//    public UserVO accountAuthentication(ModelAndView view,UserVO user){
//                
//    			return user;
//      }
	
	

}
