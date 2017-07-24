package com.fxp.jee.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//û�д���cookie
		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(10);
		ServletContext servletContext = getServletContext();
		Integer number=(Integer)servletContext.getAttribute("total");
		resp.setContentType("text/html;charset=UTF-8");
		if(number!=null){
			resp.getWriter().write("<h3>��ǰ���û����ǣ�"+number.intValue()+"</h3><br/>");
		}
		resp.getWriter().write("<a href='show'>ˢ��</a>");
	}
}
