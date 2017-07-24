package com.fxp.jee.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReqinfoServlet extends HttpServlet {
	private static final long serialVersionUID = -1050940744144958501L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder sb=new StringBuilder();
		sb.append("<strong>request÷––≈œ¢:</strong>").append("<br/><br/>");
		sb.append("request uri:").append(req.getRequestURI()).append("<br/>");
		sb.append("content length:").append(req.getContentLength()).append("<br/>");
		sb.append("method:").append(req.getMethod()).append("<br/>");
		sb.append("<hr/>------------------headers--------------------<br/>");
		Enumeration<String> headerNames = req.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String name = headerNames.nextElement();
			sb.append(name).append(" -> ").append(req.getHeader(name)).append("<br/>");
		}
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write(sb.toString());
	}
}
