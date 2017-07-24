package com.fxp.jee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessingServlet extends HttpServlet {
	private static final long serialVersionUID = 4648044383568375821L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		System.out.println("name:"+name+" age:"+age);
		res.setHeader("Content-Type", "text/html;charset=UTF-8");//不添加会网页乱码
		res.getWriter().write("name:"+name+" age:"+age);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");//这种方法在post中有效
		String name=req.getParameter("name");
//		name=new String(name.getBytes("ISO8859-1"),"UTF-8");//解决乱码
		String age=req.getParameter("age");
		resp.setHeader("Content-Type", "text/html;charset=UTF-8");//不添加会网页乱码
		resp.getWriter().write("name:"+name+" age:"+age);
	}
}
