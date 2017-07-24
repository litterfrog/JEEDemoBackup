package com.fxp.jee.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 8881937326355465610L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		String name=req.getParameter("name");
//		String age=req.getParameter("age");
//		String file=req.getParameter("file");
//		
//		resp.setContentType("text/html;charset=UTF-8");
//		resp.getWriter().write("name:"+name+"<br/>age:"+age+"<br/>file:"+file);
		process(req,resp);
	}
	private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		resp.setContentType("text/html;charset=UTF-8");
//		ServletInputStream inputStream = req.getInputStream();
//		byte[] buf=new byte[1024];
//		int flag=0;
//		while((flag=inputStream.readLine(buf, 0, buf.length))!=-1){
//			String line=new String(buf,0,flag);
//			resp.getWriter().write(line+"<br/>");
//		}
//		inputStream.close();
		
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		
		resp.getWriter().write("<strong>name:"+name+"<br/>age:"+age+"</strong><br/>");
		
		Part part=req.getPart("file");
//		String elementName = part.getName();
//		resp.getWriter().write("elementName:"+elementName+"<br/>");
//		String fileName=getFileName(part);
//		resp.getWriter().write("fileName:"+fileName+"<br/>");
//		InputStream inputStream = part.getInputStream();
//		byte[] buf=new byte[1024];
//		int flag=0;
//		while((flag=inputStream.read(buf, 0, buf.length))!=-1){
//			String line=new String(buf,0,flag);
//			resp.getWriter().write(line+"<br/>");
//		}
//		inputStream.close();
		saveUpload(part);
		resp.getWriter().write("<h3>文件上传成功</h3>");
	}
	private void saveUpload(Part part) {
		String fileName=getFileName(part);
		fileName="fxp_"+System.nanoTime()+"_"+fileName;
		
		ServletContext context=getServletContext();
		String path = context.getRealPath("/");
		File file=new File(path+"upload");
		if(!file.exists()){
			file.mkdir();
		}
		File upFile=new File(file,fileName);
		FileOutputStream fileOutputStream=null;
		InputStream is=null;
		byte[] buf=new byte[1024];
		int flag=-1;
		try {
			fileOutputStream = new FileOutputStream(upFile);
			is=part.getInputStream();
			while((flag=is.read(buf, 0, buf.length))!=-1){
				fileOutputStream.write(buf, 0, flag);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fileOutputStream!=null){
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	private String getFileName(Part part) {
		String submittedFileName = part.getSubmittedFileName();
//		Iterator<String> iterator = part.getHeaderNames().iterator();
//		while(iterator.hasNext()){
//			String name=iterator.next();
//			System.out.println(name+":"+part.getHeader(name));
//		}
//		String header=part.getHeader("content-disposition");
//		String[] strings = header.split("\"");
//		System.out.println(strings[strings.length-1]);
		return submittedFileName;
	}
}
