package com.fxp.jee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = -5325851818269785817L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session == null||session.getAttribute("user")==null){
			resp.sendRedirect("../pages/login.html");
			
		}else{
			resp.setContentType("text/html;charset=UTF-8");
			resp.getWriter().write("<h3>��ӭ"+session.getAttribute("user")+"����TestServlet</h3><a href='../index.html'>������ҳ</a>");
		}
	}
}
