package org.myblog.common;

import java.security.MessageDigest;

/**
 * @ClassName: MD5
 * @Description: MD5加密
 * @author bobmeek
 * @date Dec 30, 2014 8:08:28 PM
 */
public class MD5 
{
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
		"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	
	public static String byteArrayToHexString(byte[] b) 
	{
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) 
		{
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}
	
	private static String byteToHexString(byte b) 
	{
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	
	/**
	 * @Description  MD5+盐值 加密
	 * @author bobmeek
	 * @Title MD5Encode
	 * @param @param username 用户名 - 作为盐值
	 * @param @param userpwd 密码
	 * @param @return 加密后的值
	 * @return String    返回类型
	 */
	public static String MD5Encode(String username,String userpwd) 
	{
		String resultString = null;

		try 
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(mergePasswordAndSalt(userpwd,username).getBytes()));
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		return resultString;
	}
	
	 /**借用用户名作为盐值加密**/
	 public static String mergePasswordAndSalt(String userpwd,String salt) {
	        if (userpwd == null) {
	        	userpwd = "";
	        }

	        if ((salt == null) || "".equals(salt)) {
	            return userpwd;
	        } else {
	            return userpwd + "{" + salt.toString() + "}";
	        }
	    }
}