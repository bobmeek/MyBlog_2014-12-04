package org.myblog.dto;

import java.util.Date;

/**   
 * @desc   [ 数据备份文件实体 ]
 * @author [ bobmeek ]   
 * @time   [ 2015年3月14日 下午10:12:24 ] 
 *
 */
public class DataFile {
	private String fileName;
	private String fileSize;
	private String time;
	public DataFile() {
		
	}
	public DataFile(String fileName, String fileSize, String time) {
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.time = time;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
}
