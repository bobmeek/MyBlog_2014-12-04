/**  
 * @Title: Demo.java
 * @Package org.yuzheng.date
 * @Description: TODO
 * @author yuzheng.xia
 * @date 2014-1-8 ����10:44:40
 * @version V1.0  
 */
package org.myblog.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;
/**
 * @ClassName: Demo
 * @Description: ����ʱ�����ڵĸ�ʽ��ת��
 * @author yuzheng.xia
 * @date 2014-1-8 ����10:44:40
 */
public class DateUtil
{

	
	public static void main(String[] args) throws Exception
	{
		System.out.println(getMonth());
		//���ַ���ת����date����
		String time = "2014-01-08 22:22";
		System.out.println(convertDate("yyyy/MM/dd HH:mm", 1389193877464L));
		
	}
	
	private final static String DATE_FORMAT = "yyyy-MM-dd";  
    private final static String DATE_FORMAT_CN = "yyyy��MM��dd��";  
    private final static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";  
    private final static String TIME_FORMAT_CN = "yyyy��MM��dd�� HH:mm:ss";  
    private final static String MONTH_FORMAT = "yyyy-MM";  
    private final static String DAY_FORMAT = "yyyyMMdd";  
    
    
    private static Calendar cal = Calendar.getInstance();
    
    
    	

    
    
    /**
     * 
     * @desc   [ ȡ�õ�ǰϵͳʱ��� ]
     * @param  [ @return ]
     * @author [ bobmeek ]   
     * @time   [ 2015-4-30 ����11:20:50 ] 
     *
     */
    public static java.sql.Timestamp getCurrTimestamp() {
        return new java.sql.Timestamp(System.currentTimeMillis());
    }
    
    /**
     * 
     * @desc   [ ȡ�õ�ǰϵͳʱ��� ]
     * @param  [ @return ]
     * @author [ bobmeek ]   
     * @time   [ 2015-4-30 ����11:20:50 ] 
     *
     */
    public static String getYear(){
    	return String.valueOf(cal.get(Calendar.YEAR));
    }
    /**
     * 
     * @desc   [ ȡ�õ�ǰ�·�]
     * @param  [ @return ]
     * @author [ bobmeek ]   
     * @time   [ 2015-4-30 ����11:20:50 ] 
     *
     */
    public static String getMonth(){
    	return String.valueOf(cal.get(Calendar.MONTH)+1);
    }
    /**
     * 
     * @desc   [ ȡ�õ�ǰ�·��е����� ]
     * @param  [ @return ]
     * @author [ bobmeek ]   
     * @time   [ 2015-4-30 ����11:20:50 ] 
     *
     */
    public static String getDay(){
    	return String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
    }
    
    
    
    
    
    
	
	/**
	 * @Description���SimpleDateFormat  
	 * @author bobmeek
	 * @Title getSimpleDateFormat
	 * @param @return
	 * @return SimpleDateFormat    ��������
	 */
	public static SimpleDateFormat getSimpleDateFormat(String pattern)
	{	if("".equals(pattern) || null==pattern)
			pattern = "yyyy-MM-dd HH:mm";
		return new SimpleDateFormat(pattern);
	}
	
	/**
	 * @Description ���ַ���ת����date  
	 * @author bobmeek
	 * @Title convertDate
	 * @param @param time
	 * @param @return
	 * @param @throws Exception
	 * @return Date    ��������
	 */
	public static Date convertDate(String pattern,String time) throws Exception
	{
		return getSimpleDateFormat(pattern).parse(time);
	}
	
	/**
	 * @Description ��long ת���� date  
	 * @author bobmeek
	 * @Title convertDate
	 * @param @param time
	 * @param @return
	 * @param @throws Exception
	 * @return Date    ��������
	 */
	public static Date convertDate(String pattern,long time) throws Exception
	{
		return getSimpleDateFormat(pattern).parse(getSimpleDateFormat(pattern).format(new Date(time)));
	}
	
	/**
	 * @Description ��date���͵����ڸ�ʽ��  
	 * @author bobmeek
	 * @Title convertDateFormat
	 * @param @param time
	 * @param @return
	 * @param @throws Exception
	 * @return String    ��������
	 */
	public static String convertDateFormat(String pattern,Date time) throws Exception
	{
		return getSimpleDateFormat(pattern).format(time);
	}
	
	
	/**
	 * @Description ��timestamp����ת����String
	 * @author bobmeek
	 * @Title convertTimestamp
	 * @param @param time
	 * @param @return
	 * @param @throws Exception
	 * @return String    ��������
	 */
	public static String convertString(String pattern,Timestamp time)throws Exception
	{
		return getSimpleDateFormat(pattern).format(time);
	}
	
	/**
	 * 
	 * @desc   [ ��long����ת����String ]
	 * @param  [ @param pattern
	 * @param  [ @param time
	 * @param  [ @return
	 * @param  [ @throws Exception ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015��3��14�� ����10:53:07 ] 
	 *
	 */
	public static String convertString(String pattern,long time) throws Exception{
		return convertString(pattern,convertTimestamp(pattern,time));
	}
	
	/**
	 * @Description  ��date����ת����Timestamp
	 * @author bobmeek
	 * @Title convertTimestamp
	 * @param @param time
	 * @param @return
	 * @param @throws Exception
	 * @return Timestamp    ��������
	 */
    public static Timestamp convertTimestamp(String pattern,Date time) throws Exception
    {

    	//����һ��String�ַ������� 
    	return convertTimestamp(pattern,getSimpleDateFormat(pattern).format(time));
    }
    
    /***
     * @Description ��String����ת����Timestamp  
     * @author bobmeek
     * @Title convertTimestamp
     * @param @param time
     * @param @return
     * @param @throws Exception
     * @return Timestamp    ��������
     */
    public static Timestamp convertTimestamp(String pattern,String time) throws Exception
    {

    	//����һ��long���͵�����
    	return new Timestamp(getSimpleDateFormat(pattern).parse(time).getTime());
    }
    
    /**
     * 
     * @Description  ��long����ת����Timestamp
     * @author bobmeek
     * @Title convertTimestamp
     * @param @param time
     * @param @return
     * @param @throws Exception
     * @return Timestamp    ��������
     */
    public static Timestamp convertTimestamp(String pattern,long time) throws Exception
    {

    	//����һ��Date���͵�����
    	return convertTimestamp(pattern,new Date(time));
    }
	
}
