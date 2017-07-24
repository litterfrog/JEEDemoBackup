package com.fxp.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	//封装文件标题请求参数字段
	private String title;
	//封装上传文件域的字段
	private File upload;
	//封装上传文件类型的字段
	private String uploadContentType;
	//封装上传文件名的字段
	private String uploadFileName;
	//在struts.xml文件中配置上传文件保存位置的字段
	private String savePath;
	@Override
	public String execute() throws Exception {
		String newName=uploadFileName+"."+UUID.randomUUID();
		File file=new File(getSavePath(),newName);
//		if(!file.exists()){
//			file.mkdirs();
//		}
		FileOutputStream fos=new FileOutputStream(file);
		FileInputStream fis=new FileInputStream(getUpload());
		byte[] buffer=new byte[1024];
		int len=0;
		while((len=fis.read(buffer))>0){
			fos.write(buffer,0,len);
		}
		fos.close();
		fis.close();
		setUploadFileName(newName);
		return SUCCESS;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
}
