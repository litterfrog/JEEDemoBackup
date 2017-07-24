package com.fxp.jee.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1367478088598854038L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Servlet1 doGet");
/*		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write("<strong>Servlet1!</strong><br/>");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("s2");*/
		//forward≤‚ ‘
/*		req.setAttribute("test", Math.random());
		requestDispatcher.forward(req, resp);*/
		//include≤‚ ‘
/*		requestDispatcher.include(req, resp);
		Double d=(Double)req.getAttribute("test");
		resp.getWriter().write("include servlet2 double values:"+d);*/
		//÷ÿ∂®œÚ≤‚ ‘
		resp.sendRedirect("s2");
	}
}
