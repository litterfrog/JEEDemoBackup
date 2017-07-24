package com.fxp.jee.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLifeCycle2 extends HttpServlet{
	private static final long serialVersionUID = 7264538139499082921L;





	//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		print("init");
//		System.out.println("init-param:"+config.getInitParameter("test"));
//	}
	@Override
	public void init() throws ServletException {
		print("init");
		System.out.println("init-param:"+getInitParameter("test"));
	}
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		print("service");
		System.out.println(getServletContext().hashCode());
	}
	@Override
	public void destroy() {
		print("destroy");
	}
	
	
	
	
	
	private void print(String content){
		System.out.println(getClass().getSimpleName()
				+"method name:"+content
				+" thread name:"+Thread.currentThread().getName());
	}
}
