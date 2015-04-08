/**  
 * @Title: LoginControllerr.java
 * @Package org.myblog.controller
 * @Description: TODO
 * @author bobmeek
 * @date Dec 14, 2014 10:52:40 AM
 * @version V1.0  
 */
package org.myblog.controller;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.myblog.common.BaseUtils;
import org.myblog.common.DateUtil;
import org.myblog.common.EmailUtil;
import org.myblog.common.MD5;
import org.myblog.common.Pager;
import org.myblog.common.VerifyCodeUtil;
import org.myblog.common.page.Page;
import org.myblog.common.page.PageUtil;
import org.myblog.model.RoleVO;
import org.myblog.model.UserExtVO;
import org.myblog.model.UserVO;
import org.myblog.service.facade.RoleService;
import org.myblog.service.facade.UserExtService;
import org.myblog.service.facade.UserService;
import org.myblog.shiro.password.PasswordHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * @ClassName: LoginControllerr
 * @Description: TODO
 * @author bobmeek
 * @date Dec 14, 2014 10:52:40 AM
 */
@Controller
@RequestMapping(value={"/user/","/admin/"})
public class UserController
{

	@Resource(name = "userServiceImpl")
	private UserService userService;
	
	@Resource(name = "userExtServiceImpl")
	private UserExtService userExtService;
	
	@Resource(name = "roleServiceImpl")
	private RoleService roleService;
	
	@Resource(name = "passwordHelper")
	private PasswordHelper passwordHelper;

	
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
	@RequestMapping(value = "/add",produces = "application/json")
	@ResponseBody
	public UserVO add(HttpServletRequest request, UserVO user) throws Exception
	{	
		user.setRegisterTime(DateUtil.convertTimestamp("yyyy-MM-dd HH:mm",new Date()));
		user.setRegisterIP(BaseUtils.getPublidIp());
		user.setIsEmailActive(0);
		user.setIsDisabled(1);
		
		//将密码加密交给shiro处理
		passwordHelper.encryptPassword(user);
		
		// 对密码进行MD5加密  + 盐值
		//user.setUserpwd(MD5.MD5Encode(user.getUsername(),user.getUserpwd()));
		// 发送激活邮件
		if(!"".equals(user.getEmail()) && null!=user.getEmail())
			EmailUtil.sendAccountActivateEmail(user);
		
		//保存用户基本信息
		userService.saveUser(user);
		userService.addRoleRelation(user.getId(), 5);
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
				user.setLastLoginIP(BaseUtils.getPublidIp());
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
	
	@RequestMapping(value="/delete/idArr",produces=("application/json"))
	@ResponseBody
	public int deleteUserBatch(@RequestBody int[] idArr)
	{
		List<Integer> ids = new ArrayList<Integer>();
		for (int i : idArr)
		{
			ids.add(i);
		}
		userExtService.deleteBatch(ids);
		return 1;
	}
	
	
	
	@RequestMapping(value="/show/allUsers",produces="application/json")
	@ResponseBody
	public ModelMap showAllUsersByPager(int currentPage,ModelMap modelMap)
	{
		int pageCount = 5;
		int totalCount = userService.getTotalNum();
		Page page = PageUtil.createPage(pageCount, currentPage, totalCount);
		int totalPage = page.getTotalPage();
		currentPage = page.getCurrentPage();
		int startIndex = page.getSrartIndex();
		boolean hasPrePage = page.isHasPrePage();
		boolean hasNextPage = page.isHasNextPage(); 
		
		Pager<UserVO> pagers = userService.findByPage(startIndex, pageCount);
		List<UserVO> users = pagers.getPageList();
		List<RoleVO> roles = roleService.findAll();
		
		modelMap.addAttribute("roles",roles);
		modelMap.addAttribute("users",users);
		modelMap.addAttribute("totalCount",totalCount);
		modelMap.addAttribute("totalPage",totalPage);
		modelMap.addAttribute("currentPage",currentPage);
		modelMap.addAttribute("hasPrePage",hasPrePage);
		modelMap.addAttribute("hasNextPage",hasNextPage);
		
		return modelMap;
	}
	
	@RequestMapping(value="/add/roleRelation")
	@ResponseBody
	public void addRoleRelation(int userId,int roleId)
	{
		
		userService.addRoleRelation(userId, roleId);
		
	}
	
	@RequestMapping(value="/delete/roleRelation")
	@ResponseBody
	public void deleteRoleRelation(int userId,int roleId)
	{
		
		userService.deleteRoleRelation(userId, roleId);
		
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
	
	/** 
     * 获取验证码图片和文本(验证码文本会保存在HttpSession中) 
     */  
    @RequestMapping("/getVerifyCodeImage")  
    public void getVerifyCodeImage(HttpServletRequest request, HttpServletResponse response) throws IOException {  
        //设置页面不缓存  
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 4, null);  
        //将验证码放到HttpSession里面  
        request.getSession().setAttribute("verifyCode", verifyCode);  
        System.out.println("本次生成的验证码为[" + verifyCode + "],已存放到HttpSession中");  
        //设置输出的内容的类型为JPEG图像  
        response.setContentType("image/jpeg");  
        BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, Color.BLACK, null);  
        //写给浏览器  
        ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());  
    }  
	
	/** 
     * 后台用户登录 
     */  
    @RequestMapping(value="/index", method={RequestMethod.POST})  
    public String login(HttpServletRequest request,String username,String userpwd,boolean rememberMe){
    	
    	request.setAttribute("username", username);
        String resultPageURL = InternalResourceViewResolver.FORWARD_URL_PREFIX + "/view/admin/login.jsp";  
        //获取HttpSession中的验证码  
        String verifyCode = (String)request.getSession().getAttribute("verifyCode");  
        //获取用户请求表单中输入的验证码  
        String submitCode = WebUtils.getCleanParam(request, "verifyCode");  
        System.out.println("用户[" + username + "]登录时输入的验证码为[" + submitCode + "],HttpSession中的验证码为[" + verifyCode + "]");  
        if (StringUtils.isEmpty(submitCode) || !StringUtils.equals(verifyCode, submitCode.toLowerCase())){  
            request.setAttribute("message_login", "验证码不正确");  
            return resultPageURL;  
        }  
        UsernamePasswordToken token = new UsernamePasswordToken(username, userpwd);
        //记住密码即保存Cookie,关闭浏览器时按照设置Cookie留存的时间判断是否重新登录.
        //当Session没有过期,关闭浏览器后,设置的Cookie还未过期,则不需要重新登录.
        token.setRememberMe(rememberMe);  
        System.out.println("为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));  
        //获取当前的Subject  
        Subject currentUser = SecurityUtils.getSubject();  
        try {  
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查  
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应  
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法  
            System.out.println("对用户[" + username + "]进行登录验证..验证开始");  
            currentUser.login(token);  
            System.out.println("对用户[" + username + "]进行登录验证..验证通过");
            //设置Session过期时间为30分钟,当Session过期后,则需要重新登录.
            currentUser.getSession().setTimeout(1000*60*30);
            resultPageURL = "admin/index";  
        }catch(UnknownAccountException uae){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,未知账户");  
            request.setAttribute("message_login", "该账户没有进行注册");  
        }catch(IncorrectCredentialsException ice){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");  
            request.setAttribute("message_login", "密码不正确");  
        }catch(LockedAccountException lae){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");  
            request.setAttribute("message_login", "账户已锁定");  
        }catch(ExcessiveAttemptsException eae){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");  
            request.setAttribute("message_login", "用户名或密码错误次数过多");  
        }catch(AuthenticationException ae){  
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");  
            ae.printStackTrace();  
            request.setAttribute("message_login", "用户名或密码不正确");  
        }  
        //验证是否登录成功  
        if(currentUser.isAuthenticated()){  
            System.out.println("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)"); 
        }else{  
            token.clear();  
        }  
        return resultPageURL;  
    }  
	
	 @RequestMapping(value="/logout",method=RequestMethod.GET)    
	 public String logout(HttpServletRequest request,RedirectAttributes redirectAttributes ){
		 	Subject subject = SecurityUtils.getSubject();
		 	String username = (String) subject.getPrincipal();
		 	request.setAttribute("username", username);
	        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息  
		 	subject.logout();    
	        request.setAttribute("message_login", "您已安全退出");
	        return "admin/login";  
	    }   
	
	

}
