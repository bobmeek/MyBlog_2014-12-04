package org.myblog.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.myblog.common.BaseUtils;

/**   
 * @desc   [  ]
 * @author [ bobmeek ]   
 * @time   [ 2015年3月19日 上午10:37:51 ] 
 *
 */
public class DataBackupT {
	public static void main(String[] args) {
		
		 Properties prop = new Properties();  
	        try {  
	            prop.load(new FileInputStream("classpath:data.properties"));  
	              
	            System.out.println(prop.getProperty("username"));  
  
	        } catch(IOException e) {  
	            e.printStackTrace();  
	        }  
	}
	
	
	
	public static void backup(){
		String proPath = "G:\\Data Backup\\aa";
		File file = new File(proPath);
		//如果备份目录不存在,则创建.
		if(!file.exists())
			file.mkdirs();
		String backupSQL = "mysqldump -uroot -proot --opt myblog_2014-12-04 > " + proPath.replace(" ", "\" \"")+"\\xxx.sql";
		try {
			Runtime.getRuntime().exec("cmd /C "+backupSQL).waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
