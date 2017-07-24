package com.fxp.jee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Cookie[] cookies=req.getCookies();
		if(null==cookies){
			resp.sendRedirect("index.html");
			return;
		}
		StringBuilder sb=new StringBuilder("<h3>Cookie–≈œ¢:</h3>");
		for(Cookie c:cookies){
			sb.append("<li>").append(c.getName()).append("->").append(c.getValue()).append("</li>");
			
		}
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write(sb.toString());
		
	}
}
