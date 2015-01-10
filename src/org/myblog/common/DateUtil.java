/**  
 * @Title: Demo.java
 * @Package org.yuzheng.date
 * @Description: TODO
 * @author yuzheng.xia
 * @date 2014-1-8 下午10:44:40
 * @version V1.0  
 */
package org.myblog.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;
/**
 * @ClassName: Demo
 * @Description: 对于时间日期的格式化转换
 * @author yuzheng.xia
 * @date 2014-1-8 下午10:44:40
 */
public class DateUtil
{

	
	public static void main(String[] args) throws Exception
	{
		//将字符串转换成date类型
		String time = "2014-01-08 22:22";
		System.out.println(convertDate(Long.parseLong("1389193877464")));
		
	}
	
	
	/**
	 * @Description获得SimpleDateFormat  
	 * @author bobmeek
	 * @Title getSimpleDateFormat
	 * @param @return
	 * @return SimpleDateFormat    返回类型
	 */
	public static SimpleDateFormat getSimpleDateFormat()
	{
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return new SimpleDateFormat(pattern);
	}
	
	/**
	 * @Description 将字符串转换成date  
	 * @author bobmeek
	 * @Title convertDate
	 * @param @param time
	 * @param @return
	 * @param @throws Exception
	 * @return Date    返回类型
	 */
	public static Date convertDate(String time) throws Exception
	{
		return getSimpleDateFormat().parse(time);
	}
	
	/**
	 * @Description 将long 转换成 date  
	 * @author bobmeek
	 * @Title convertDate
	 * @param @param time
	 * @param @return
	 * @param @throws Exception
	 * @return Date    返回类型
	 */
	public static Date convertDate(long time) throws Exception
	{
		return getSimpleDateFormat().parse(getSimpleDateFormat().format(new Date(time)));
	}
	
	/**
	 * @Description 将date类型的日期格式化  
	 * @author bobmeek
	 * @Title convertDateFormat
	 * @param @param time
	 * @param @return
	 * @param @throws Exception
	 * @return String    返回类型
	 */
	public static String convertDateFormat(Date time) throws Exception
	{
		return getSimpleDateFormat().format(time);
	}
	
	/**
	 * @Description  将date类型转换成Timestamp
	 * @author bobmeek
	 * @Title convertTimestamp
	 * @param @param time
	 * @param @return
	 * @param @throws Exception
	 * @return Timestamp    返回类型
	 */
    public static Timestamp convertTimestamp(Date time) throws Exception
    {

    	//传了一个String字符串日期 
    	return convertTimestamp(getSimpleDateFormat().format(time));
    }
    
    /***
     * @Description 将String类型转换成Timestamp  
     * @author bobmeek
     * @Title convertTimestamp
     * @param @param time
     * @param @return
     * @param @throws Exception
     * @return Timestamp    返回类型
     */
    public static Timestamp convertTimestamp(String time) throws Exception
    {

    	//传了一个long类型的日期
    	return new Timestamp(getSimpleDateFormat().parse(time).getTime());
    }
    
    /**
     * 
     * @Description  将long类型转换成Timestamp
     * @author bobmeek
     * @Title convertTimestamp
     * @param @param time
     * @param @return
     * @param @throws Exception
     * @return Timestamp    返回类型
     */
    public static Timestamp convertTimestamp(long time) throws Exception
    {

    	//传了一个Date类型的日期
    	return convertTimestamp(new Date(time));
    }
	
}
