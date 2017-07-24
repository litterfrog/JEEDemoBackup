package com.fxp.jee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveCookieServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Cookie c1=new Cookie("test1","test1-cookie");
	resp.addCookie(c1);
	
	Cookie c2=new Cookie("test2", "test2-cookie");
	c2.setPath("/");
	resp.addCookie(c2);
	
	Cookie c3=new Cookie("test3", "test3-cookie");
	//这个读不到
	c3.setPath("/temp/");
	//这样可以得到，不过要修改servlet路径与cookie保持一致
//	c3.setPath("/SessionTrack/temp/");
	resp.addCookie(c3);
	resp.sendRedirect("index.html");
}

}
