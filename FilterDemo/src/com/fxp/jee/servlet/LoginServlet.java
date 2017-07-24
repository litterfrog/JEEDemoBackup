package com.fxp.jee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		System.out.println("user name:"+name);
		if("admin".equals(name)&&"123".equals(password)){
			HttpSession session=req.getSession();
			session.setAttribute("user_name", name);
			resp.sendRedirect("index.html");
		}else{
			resp.sendRedirect("login.html");
		}
	}
}
