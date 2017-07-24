package com.fxp.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
	//代表下载文件的资源路径
	private String inputPath;
	//代表下载文件的文件路径
	private String contentType;
	//代表下载文件的文件名
	private String downloadFileName;
	public String getInputPath() {
		return inputPath;
	}
	public void setInputPath(String inputPath) throws Exception{
		//处理请求参数的解码
		this.inputPath = new String(inputPath.getBytes("iso-8859-1"),"gbk");
		System.out.println(this.inputPath);
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getDownloadFileName() {
		return downloadFileName;
	}
	public void setDownloadFileName(String downloadFileName) throws Exception {
		this.downloadFileName = new String(downloadFileName.getBytes("iso-8859-1"),"gbk");
	}
	/*
	 * 定义一个返回InputStream的方法
	 * 该方法将作为被下载文件的入口，
	 * 且需要配置stream类型结果时指定inputName参数，
	 * InputName参数的值就是方法去掉get前缀，首字母小写的字符串
	 */
	public InputStream getTargetFile() throws Exception{
		//ServletContext提供的getResourceAsStream()方法返回指定文件对应的输入流
		return ServletActionContext.getServletContext().getResourceAsStream(inputPath);
		
	}
}
