package org.myblog.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.myblog.dto.DataFile;

/**   
 * @desc   [ 数据库处理工具类 ]
 * @author [ bobmeek ]   
 * @time   [ 2015年3月19日 上午11:40:25 ] 
 *
 */
public class DataBaseUtil {

	
	
	private static Properties PROP = new Properties();
	
	/**
	 * 
	 * @desc   [ 加载properties数据文件 ]
	 * @param  [ @param dir properties所在文件夹 ]
	 * @param  [ @return ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月19日 下午12:09:08 ] 
	 *
	 */
	public static Properties loadProperties(String dir){
		
		try {
			PROP.load(new FileInputStream(dir));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return PROP;
	}
	
	/**获取数据库名称**/
	public static String getDataBase(){
		return PROP.getProperty("database");
	}
	
	/**获取数据库用户名**/ 
	public static String getUserName(){
		 return PROP.getProperty("db.username");
	}
	
	/**获取数据库密码**/
	public static String getPassWord(){
		return PROP.getProperty("db.password");
	}
	
	/**获取数据库IP地址**/
	public static String getIP(){
		return PROP.getProperty("db.ip");
	}
	
	/**
	 * 
	 * @desc   [ 备份数据 ]
	 * 用replace处理带有空格的文件夹 - .replace("","\" \"");  
	 * \ - 转义符 , [\"] - 左引号 , [ \"] - 右引号 , 左引号与右引号之间有一个空格. 
	 * 处理完带有空格的文件夹名称 - 比如:修改前:Apache Tomcat6.0 , 修改后:Apache" "Tomcat6.0 .
	 * @param  [ @param nextPath 根目录下的子文件夹 - 比如:MyBlog_2014-12-04\WEB-INF 或者 MyBlog_2014-12-04\resources 等.
	 * @param  [ @param fileName 备份数据的文件名称.
	 * @param  [ @return
	 * @param  [ @throws URISyntaxException ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月19日 下午1:05:42 ] 
	 *
	 */
	public static boolean backup(String nextPath,String fileName) throws URISyntaxException {
		String backSQL = "mysqldump -h"+getIP()+" -u"+getUserName()+" -p"+getPassWord()+" --opt "+getDataBase()+" > " + BaseUtils.getServerPath(nextPath).replace(" ", "\" \"");
		//System.out.println(backSQL+fileName);
		
		try {
			Runtime.getRuntime().exec("cmd /C"+backSQL+fileName).waitFor();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	/**
	 * 
	 * @desc   [ 还原数据 ]
	 * 用replace处理带有空格的文件夹 - .replace("","\" \"");  
	 * \ - 转义符 , [\"] - 左引号 , [ \"] - 右引号 , 左引号与右引号之间有一个空格. 
	 * 处理完带有空格的文件夹名称 - 比如:修改前:Apache Tomcat6.0 , 修改后:Apache" "Tomcat6.0 .
	 * @param  [ @param nextPath 根目录下的子文件夹 - 比如:MyBlog_2014-12-04\WEB-INF 或者 MyBlog_2014-12-04\resources 等.
	 * @param  [ @param fileName 备份数据的文件名称.
	 * @param  [ @return
	 * @param  [ @throws URISyntaxException ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月19日 下午1:05:42 ] 
	 */
	public static boolean recover(String nextPath,String fileName) throws URISyntaxException {
		String recoverSQL = "mysqldump -u"+getUserName()+" -p"+getPassWord()+" "+getDataBase()+" < " + BaseUtils.getServerPath(nextPath).replace(" ", "\" \"");
		try {
			Runtime.getRuntime().exec("cmd /C"+recoverSQL+fileName).waitFor();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 
	 * @desc   [ 删除备份文件 ]
	 * @param  [ @param nextPath 根目录下的子文件夹 - 比如:MyBlog_2014-12-04\WEB-INF 或者 MyBlog_2014-12-04\resources 等.
	 * @param  [ @param fileName 备份数据的文件名称.
	 * @param  [ @return
	 * @param  [ @throws URISyntaxException ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月19日 下午1:09:34 ] 
	 *
	 */
	public static boolean delete(String nextPath,String fileName) throws URISyntaxException {
		File file = new File(BaseUtils.getServerPath(nextPath)+fileName);
		return file.isFile() && file.exists() ?  file.delete() :  false;
	}
	
	/**
	 * 
	 * @desc   [ 显示备份文件夹中的所有备份文件 ]
	 * @param  [ @param nextPath 根目录下的子文件夹 - 比如:MyBlog_2014-12-04\WEB-INF 或者 MyBlog_2014-12-04\resources 等.
	 * @param  [ @return
	 * @param  [ @throws URISyntaxException ]
	 * @author [ bobmeek ]   
	 * @time   [ 2015年3月19日 下午1:10:00 ] 
	 *
	 */
	public static List<DataFile> show(String nextPath) throws URISyntaxException {
		File file = new File(BaseUtils.getServerPath(nextPath));
		File[] files = file.listFiles();
		List<DataFile> list = new ArrayList<DataFile>();
		for (File f : files) {
			DataFile dataFile = new DataFile();
			dataFile.setFileName(f.getName());
			String fileSize = (f.length()/1000<1000) ? f.length()/1000+"k":f.length()/1000/1000+"M";
			dataFile.setFileSize(fileSize);
			try {
				dataFile.setTime(DateUtil.convertString("yyyy/MM/dd HH:mm", f.lastModified()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add(dataFile);
			
		}
		return list;
	}
	
	
}
