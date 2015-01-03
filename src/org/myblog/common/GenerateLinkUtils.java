/**  
 * @Title: GenerateLinkUtils.java
 * @Package org.myblog.common
 * @Description: TODO
 * @author bobmeek
 * @date Dec 30, 2014 10:42:24 AM
 * @version V1.0  
 */
package org.myblog.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletRequest;

import org.myblog.model.UserVO;
	
/**
 * @ClassName: GenerateLinkUtils
 * @Description: 生成激活链接
 * @author bobmeek
 * @date Dec 30, 2014 10:42:24 AM
 */
public class GenerateLinkUtils
{
	private static final String CHECK_CODE = "checkCode";  
    
    /** 
     * 生成帐户激活链接 
     */  
    public static String generateActivateLink(UserVO user) {  
        return "http://192.168.1.104:8080/MyBlog_2014-12-04/user/activeMail.do?mail="   
                + user.getMail() + "&" + CHECK_CODE + "=" + generateCheckcode(user);  
    }  
      
    /** 
     * 生成重设密码的链接 
     */  
    public static String generateResetPwdLink(UserVO user) {  
        return "http://192.168.1.104:8080/AccountActivate/resetPasswordUI?userName="   
                + user.getUsername() + "&" + CHECK_CODE + "=" + generateCheckcode(user);  
    }  
      
    /** 
     * 生成验证帐户的MD5校验码 
     * @param UserVO  要激活的帐户 
     * @return 将用户名和密码组合后，通过md5加密后的16进制格式的字符串 
     */  
    public static String generateCheckcode(UserVO user) {  
//        String userName = UserVO.getUsername();  
//        String randomCode = UserVO.getRandomCode();
//        
//        return md5(userName + ":" + randomCode);
    	
    	return user.getUserpwd();
    }  
      
    /** 
     * 验证校验码是否和注册时发送的验证码一致 
     * @param UserVO 要激活的帐户 
     * @param checkcode 注册时发送的校验码 
     * @return 如果一致返回true，否则返回false 
     */  
    public static boolean verifyCheckcode(UserVO user,ServletRequest request) {  
        String checkCode = request.getParameter(CHECK_CODE);  
        return generateCheckcode(user).equals(checkCode);  
    }  
  
    private static String md5(String string) {  
        MessageDigest md = null;  
        try {  
            md = MessageDigest.getInstance("md5");  
            md.update(string.getBytes());  
            byte[] md5Bytes = md.digest();  
            return bytes2Hex(md5Bytes);  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
          
        return null;  
    }  
      
    private static String bytes2Hex(byte[] byteArray)  
    {  
        StringBuffer strBuf = new StringBuffer();  
        for (int i = 0; i < byteArray.length; i++)  
        {  
            if(byteArray[i] >= 0 && byteArray[i] < 16)  
            {  
                strBuf.append("0");  
            }  
            strBuf.append(Integer.toHexString(byteArray[i] & 0xFF));  
        }  
        return strBuf.toString();  
    }  
}
