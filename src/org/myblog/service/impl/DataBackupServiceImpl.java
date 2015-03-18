package org.myblog.service.impl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.myblog.common.DateUtil;
import org.myblog.dto.DataFile;
import org.myblog.service.facade.DataBackupService;
import org.springframework.stereotype.Service;

/**   
 * @desc   [ 网站数据操作 ]
 * @author [ bobmeek ]   
 * @time   [ 2015年3月14日 下午12:41:53 ] 
 *
 */
@Service
public class DataBackupServiceImpl implements DataBackupService {
	
	private static String proPath = "";
	static{
		
		try {
			proPath = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		 // 判断是否为windows.
        if(System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1)
            proPath = proPath.substring(1, proPath.indexOf("WEB-INF")) + "resources/data_backup/";
        else
            proPath = proPath.substring(0, proPath.indexOf("WEB-INF")) + "resources/data_backup/";
		
	}
	private final static String BACKUPSQL = "mysqldump -uroot -proot --opt myblog_2014-12-04 > " + proPath;
	private final static String RECOVERSQL = "mysql -uroot -proot myblog_2014-12-04 < " + proPath;
	@Override
	public boolean backup(String fileName) {
		System.out.println(BACKUPSQL+fileName);
		
		try {
			Runtime.getRuntime().exec("cmd /C"+BACKUPSQL+fileName).waitFor();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	@Override
	public boolean recover(String fileName) {
		try {
			Runtime.getRuntime().exec("cmd /C"+RECOVERSQL+fileName).waitFor();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean delete(String fileName) {
		File file = new File(proPath+fileName);
		return file.isFile() && file.exists() ?  file.delete() :  false;
	}
	
	@Override
	public List<DataFile> show() {
		File file = new File(proPath);
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
