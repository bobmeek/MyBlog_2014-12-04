/**  
 * @Title: CommonUtils.java
 * @Package org.myblog.common
 * @Description: TODO
 * @author bobmeek
 * @date Jan 10, 2015 1:54:27 PM
 * @version V1.0  
 */
package org.myblog.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;


/**   
 * @desc   [ 基本工具类 ]
 * @author [ bobmeek ]   
 * @time   [ 2015年3月19日 上午11:07:04 ] 
 *
 */
public class BaseUtils
{
	
	/**
	 * 
	 * @desc   [ 获取项目的服务器根目录 ]
	 * @param  [ @param nextPath 根目录下的子文件夹 - 比如:MyBlog_2014-12-04\WEB-INF 或者 MyBlog_2014-12-04\resources 等. ]
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月19日 上午11:44:52 ] 
	 *
	 */
	public static String getServerPath(String nextPath) throws URISyntaxException{
		String serverPath = "";
		String classesPath = getClassesPath();
		 // 判断是否为windows.
		if(System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1)
			serverPath = classesPath.substring(1, classesPath.indexOf("WEB-INF")) + nextPath;
		else
			serverPath = classesPath.substring(0, classesPath.indexOf("WEB-INF")) + nextPath;
		
		File dir = new File(serverPath);
		//如果备份目录不存在,则创建.
		if(!dir.exists())
			dir.mkdirs();
		return  serverPath;
	}
	
	/**获取发布到服务器中的项目classes文件夹路径**/
	public static String getClassesPath(){
			
		try {
			return  Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**获取本机外网IP地址**/
	public static String getPublidIp()
	{
		//外网IP提供者的网址
		final String EXTERNALIPPROVIDERURL = "http://city.ip138.com/ip2city.asp";
		try
		{

			URL url = new URL(EXTERNALIPPROVIDERURL);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String s = "";
			StringBuffer sb = new StringBuffer("");
			String ip = "";
			while ((s = br.readLine()) != null)
			{
				sb.append(s + "\r\n");
			}

			br.close();
			ip = sb.toString();
			int start = ip.indexOf("[") + 1;
			int end = ip.indexOf("]");
			ip = ip.substring(start, end);
			return ip;

		}
		catch (Exception e)
		{
			return "127.0.0.1";

		}
	}

}
