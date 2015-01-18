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
		System.out.println(convertDate("yyyy/MM/dd HH:mm", 1389193877464L));
		
	}
	
	
	/**
	 * @Description获得SimpleDateFormat  
	 * @author bobmeek
	 * @Title getSimpleDateFormat
	 * @param @return
	 * @return SimpleDateFormat    返回类型
	 */
	public static SimpleDateFormat getSimpleDateFormat(String pattern)
	{	if("".equals(pattern) || null==pattern)
			pattern = "yyyy-MM-dd HH:mm";
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
	public static Date convertDate(String pattern,String time) throws Exception
	{
		return getSimpleDateFormat(pattern).parse(time);
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
	public static Date convertDate(String pattern,long time) throws Exception
	{
		return getSimpleDateFormat(pattern).parse(getSimpleDateFormat(pattern).format(new Date(time)));
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
	public static String convertDateFormat(String pattern,Date time) throws Exception
	{
		return getSimpleDateFormat(pattern).format(time);
	}
	
	
	/**
	 * @Description 将timestamp类型时间格式化  
	 * @author bobmeek
	 * @Title convertTimestamp
	 * @param @param time
	 * @param @return
	 * @param @throws Exception
	 * @return String    返回类型
	 */
	public static String convertTimestamp(String pattern,Timestamp time)throws Exception
	{
		return getSimpleDateFormat(pattern).format(time);
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
    public static Timestamp convertTimestamp(String pattern,Date time) throws Exception
    {

    	//传了一个String字符串日期 
    	return convertTimestamp(pattern,getSimpleDateFormat(pattern).format(time));
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
    public static Timestamp convertTimestamp(String pattern,String time) throws Exception
    {

    	//传了一个long类型的日期
    	return new Timestamp(getSimpleDateFormat(pattern).parse(time).getTime());
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
    public static Timestamp convertTimestamp(String pattern,long time) throws Exception
    {

    	//传了一个Date类型的日期
    	return convertTimestamp(pattern,new Date(time));
    }
	
}
