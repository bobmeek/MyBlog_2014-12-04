/**  
 * @Title: LoginControllerr.java
 * @Package org.myblog.controller
 * @Description: TODO
 * @author bobmeek
 * @date Dec 14, 2014 10:52:40 AM
 * @version V1.0  
 */
package org.myblog.controller;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.map.util.JSONPObject;
import org.myblog.common.CommonUtils;
import org.myblog.common.DateUtil;
import org.myblog.common.EmailUtil;
import org.myblog.common.MD5;
import org.myblog.common.Pager;
import org.myblog.model.UserExtVO;
import org.myblog.model.UserVO;
import org.myblog.service.facade.UserExtService;
import org.myblog.service.facade.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;

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
	@RequestMapping(value = "/checked.do", produces = "application/json")
	@ResponseBody
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
	@RequestMapping(value = "/add.do",produces = "application/json")
	@ResponseBody
	public UserVO add(HttpServletRequest request, UserVO user) throws Exception
	{	
		user.setRegisterTime(DateUtil.convertTimestamp("yyyy-MM-dd HH:mm",new Date()));
		user.setRegisterIP(CommonUtils.getPublidIp());
		user.setIsEmailActive(0);
		user.setIsDisabled(1);
		
		// 对密码进行MD5加密  + 盐值
		user.setUserpwd(MD5.MD5Encode(user.getUsername(),user.getUserpwd()));
		// 发送激活邮件
		if(!"".equals(user.getEmail()) && null!=user.getEmail())
			EmailUtil.sendAccountActivateEmail(user);
		
		//保存用户基本信息
		userService.saveUser(user);
		
		//保存用户扩展信息
		UserExtVO userExt = new UserExtVO();
		userExt.setUser(user);
		userExtService.save(userExt);
		
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
				
				user.setLastLoginTime(DateUtil.convertTimestamp("yyyy-MM-dd HH:mm",new Date()));
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
	
	@RequestMapping(value="/update",produces="application/json")
	@ResponseBody
	public int updateUser(@RequestBody UserExtVO userExt)
	{
		
		userExtService.update(userExt);
		return 1;
	}
	
	@RequestMapping(value="/delete/{id}",produces=("application/json"))
	@ResponseBody
	public int deleteUser(@PathVariable int id)
	{
		userExtService.delete(id);
		return 1;
	}
	
	@RequestMapping(value="/delete/ids",produces="application/json")
	@ResponseBody
	public int deleteUserBatch(List<Integer> ids)
	{
		System.out.println(ids);

		userExtService.deleteBatch(ids);
		return 1;
	}
	
	
	
//	@RequestMapping(value="/show/allUsers",produces="application/json")
//	@ResponseBody
//	public List<UserVO> showAllUsers()
//	{
//		List<UserVO> allUsers = userService.findAll();
//		
//		return allUsers;
//	}
	 
	@RequestMapping(value="/show/allUsers",produces="application/json")
	@ResponseBody
	public Pager<UserVO> showAllUsersByPager(int pageNo,int pageSize)
	{
		Pager<UserVO> pagers = userService.findByPage(pageNo, pageSize);
		return pagers;
	}
	
	
	@RequestMapping(value="/show/{id}/ext",produces="application/json")
    @ResponseBody 
	public UserExtVO showUserExt(@PathVariable int id)
	{
		UserExtVO userDatilInfo = userExtService.findExtById(id);
		return userDatilInfo;
	}
	
	@RequestMapping(value="/upload/headpic")
	@ResponseBody
	public String uploadPic(String username,String fileType,String headPicNameOld,MultipartFile headPic, HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		
		//图片存储格式
		String headPicName = username+"_"+System.currentTimeMillis()+"."+fileType;
		 //可以在上传文件的同时接收其它参数
        //System.out.println("收到用户[" + uname + "]的文件上传请求");
        //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\resources\\upload\\文件夹中
        //这里实现文件上传操作用的是commons.io.FileUtils类,它会自动判断/upload是否存在,不存在会自动创建
        String realPath = request.getSession().getServletContext().getRealPath("resources/upload/img/head");
        //设置响应给前台内容的数据格式
        response.setContentType("text/html; charset=UTF-8");
        //设置响应给前台内容的PrintWriter对象
        PrintWriter out = response.getWriter();
        //上传文件的原名(即上传前的文件名字)
        String originalFilename = null;
        
        if(headPic.isEmpty()){
            out.print("1");
            out.flush();
            return null;
        }
        else{
            originalFilename = headPic.getOriginalFilename();
            originalFilename = headPicName;
            System.out.println("文件原名: " + originalFilename);
            System.out.println("文件名称: " + headPic.getName());
            System.out.println("文件长度: " + headPic.getSize());
            System.out.println("文件类型: " + headPic.getContentType());
            System.out.println("========================================");
            try {
                //这里不必处理IO流关闭的问题,因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
                //此处也可以使用Spring提供的MultipartFile.transferTo(File dest)方法实现文件的上传
            	File file = new File(realPath,headPicNameOld);
            	if(file.exists())
            		file.delete();
                FileUtils.copyInputStreamToFile(headPic.getInputStream(), new File(realPath, originalFilename));
            } catch (IOException e) {
                System.out.println("文件[" + originalFilename + "]上传失败,堆栈轨迹如下");
                e.printStackTrace();
                out.print("1`文件上传失败，请重试！！");
                out.flush();
                return null;
            }
        }
        System.out.println("项目名称"+request.getContextPath());
        System.out.println("resources/upload/img/head/" + originalFilename);
        out.print("0`" + "resources/upload/img/head/" + originalFilename);

        
        out.flush();
		return null;
        
		
	}
	
	
	
	
	@RequestMapping(value="/test")
	@ResponseBody
	public UserVO test()
	{
		UserVO user = new UserVO();
		user.setUsername("bobmeek");
		System.out.println("test");
		
		return user;
	}

}
