package com.fxp.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
	//���������ļ�����Դ·��
	private String inputPath;
	//���������ļ����ļ�·��
	private String contentType;
	//���������ļ����ļ���
	private String downloadFileName;
	public String getInputPath() {
		return inputPath;
	}
	public void setInputPath(String inputPath) throws Exception{
		//������������Ľ���
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
	 * ����һ������InputStream�ķ���
	 * �÷�������Ϊ�������ļ�����ڣ�
	 * ����Ҫ����stream���ͽ��ʱָ��inputName������
	 * InputName������ֵ���Ƿ���ȥ��getǰ׺������ĸСд���ַ���
	 */
	public InputStream getTargetFile() throws Exception{
		//ServletContext�ṩ��getResourceAsStream()��������ָ���ļ���Ӧ��������
		return ServletActionContext.getServletContext().getResourceAsStream(inputPath);
		
	}
}
