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
import java.io.InputStreamReader;
import java.net.URL;


/**
 * @ClassName: CommonUtils
 * @Description: TODO
 * @author bobmeek
 * @date Jan 10, 2015 1:54:27 PM
 */
public class CommonUtils
{
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
