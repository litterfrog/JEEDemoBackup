package com.fxp.jee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 5419685623664705016L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		if("admin".equals(name)&&"123".equals(password)){
			HttpSession session = req.getSession();
			session.setAttribute("user", name);
			resp.setContentType("text/html;charset=UTF-8");
			//url重写
			resp.getWriter().write("<strong>欢迎"+name+"!访问</strong><br/><a href='"+resp.encodeUrl("index.html")+"'>返回首页</a>");
			
		}else{
			resp.sendRedirect("pages/login.html");
		}
	}
}
