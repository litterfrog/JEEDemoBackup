package com.fxp.jee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveCookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie c1=new Cookie("test1","remove");
		c1.setMaxAge(0);
		resp.addCookie(c1);
		Cookie c2=new Cookie("test2","test2-cookie");
		c2.setPath("/");
		c2.setMaxAge(0);
		resp.addCookie(c2);
		Cookie c3=new Cookie("test3","remove");
		c3.setPath("/temp/");
		c3.setMaxAge(0);
		resp.addCookie(c3);
		Cookie c4=new Cookie("JSESSIONID","remove");
		c4.setMaxAge(0);
		resp.addCookie(c4);
		resp.sendRedirect("index.html");
	}
}
