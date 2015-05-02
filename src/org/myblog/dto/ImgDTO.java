package org.myblog.dto;

public class ImgDTO {

	private String file_path;
	private String fileName;
	private String success;
	
	
	public ImgDTO() {
 
	}


	public ImgDTO(String file_path, String fileName, String success) {
		super();
		this.file_path = file_path;
		this.fileName = fileName;
		this.success = success;
	}


	public String getFile_path() {
		return file_path;
	}


	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getSuccess() {
		return success;
	}


	public void setSuccess(String success) {
		this.success = success;
	}


	@Override
	public String toString() {
		return "ImgDTO [file_path=" + file_path + ", fileName=" + fileName
				+ ", success=" + success + "]";
	}

	

	
	
	
	
}
