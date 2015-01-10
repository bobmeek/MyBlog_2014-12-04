/**  
 * @Title: EmailUtils.java
 * @Package org.myblog.common
 * @Description: TODO
 * @author bobmeek
 * @date Dec 30, 2014 10:40:58 AM
 * @version V1.0  
 */
package org.myblog.common;

import java.io.IOException;  
import java.io.InputStream;  
import java.util.Date;  
import java.util.Properties;  
  
import javax.mail.Authenticator;  
import javax.mail.Message.RecipientType;  
import javax.mail.PasswordAuthentication;  
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  

import org.myblog.model.UserVO;

/**
 * @ClassName: EmailUtils
 * @Description: 邮件发送
 * @author bobmeek
 * @date Dec 30, 2014 10:40:58 AM
 */
public class EmailUtil 
{
	 private static final String FROM = "xiayuzheng521@163.com";  
	  
	    /** 
	     * 注册成功后,向用户发送帐户激活链接的邮件 
	     * @param user 未激活的用户 
	     */  
	    public static void sendAccountActivateEmail(UserVO user) {
	    	String link = GenerateLinkUtil.generateActivateLink(user);
	    	String content = "<div style='background-color:gray'>" +
	    			"<hr/>" + 
	    			"Hi," + user.getUsername()+"<br/>"+
	    			"感谢注册<a href='http://localhost:8888/MyBlog_2014-12-04/view/index.jsp'>keven官方博客</a>" + "<br/>"+
	    			"请点击以下链接激活你的账户并设置您的账号密码：" + "<br/>" +
	    			"<a href='" + link +"'>"+link+"</a>" + "<br/>" +
	    			"请勿回复此邮件，如果有疑问，请联系我们：xiayuzheng@supermap.com" + "<br/><br/>" +
	    			"- Keven&BobMeek 团队" +
	    			"</div>"; 
	    	
	        Session session = getSession();  
	        MimeMessage message = new MimeMessage(session);  
	        try {  
	            message.setSubject("帐户激活邮件");  
	            message.setSentDate(new Date());  
	            message.setFrom(new InternetAddress(FROM));  
	            message.setRecipient(RecipientType.TO, new InternetAddress(user.getEmail()));  
	            //message.setContent("<a href='" + GenerateLinkUtils.generateActivateLink(user)+"'>点击激活帐户</a>","text/html;charset=utf-8");
	            message.setContent(content,"text/html;charset=utf-8");
	            // 发送邮件  
	            Transport.send(message);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	      
	    /** 
	     * 发送重设密码链接的邮件 
	     */  
	    public static void sendResetPasswordEmail(UserVO user) {  
	        Session session = getSession();  
	        MimeMessage message = new MimeMessage(session);  
	        try {  
	            message.setSubject("找回您的帐户与密码");  
	            message.setSentDate(new Date());  
	            message.setFrom(new InternetAddress(FROM));  
	            message.setRecipient(RecipientType.TO, new InternetAddress(user.getEmail()));  
	            message.setContent("要使用新的密码, 请使用以下链接启用密码:<br/><a href='" + GenerateLinkUtil.generateResetPwdLink(user) +"'>点击重新设置密码</a>","text/html;charset=utf-8");  
	            // 发送邮件  
	            Transport.send(message);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	      
	    public static Session getSession() {  
	        Properties props = new Properties();  
	        props.setProperty("mail.transport.protocol", "smtp");  
	        props.setProperty("mail.smtp.host", "smtp.163.com");  
	        props.setProperty("mail.smtp.port", "25");  
	        props.setProperty("mail.smtp.auth", "true");  
	        Session session = Session.getInstance(props, new Authenticator() {  
	            @Override  
	            protected PasswordAuthentication getPasswordAuthentication() {  
	                String password = null;  
	                InputStream is = EmailUtil.class.getResourceAsStream("password.dat");  
	                byte[] b = new byte[1024];  
	                try {  
	                    int len = is.read(b);  
	                    password = new String(b,0,len);  
	                } catch (IOException e) {  
	                    e.printStackTrace();  
	                }  
	                return new PasswordAuthentication(FROM, password);  
	            }  
	              
	        });  
	        return session;  
	    }  
}
