package com.fxp.jee.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = -5623602929058922215L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Servlet2 doGet");
		//forward≤‚ ‘
/*		Double d = (Double)req.getAttribute("test");
		resp.getWriter().write("req attr test:"+d+"<br/>");*/
		//include≤‚ ‘
/*		req.setAttribute("test", Math.random());*/
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write("Servlet2!ƒ„∫√<br/>");
	}
}
