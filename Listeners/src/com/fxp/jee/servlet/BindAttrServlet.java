package com.fxp.jee.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BindAttrServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = getServletContext();
		System.out.println("BindAttrServlet->ServletContext add");
		context.setAttribute("context", "context...");
		System.out.println("BindAttrServlet->ServletContext added");
		System.out.println("BindAttrServlet->ServletContext replace");
		context.setAttribute("context", "context replace");
		System.out.println("BindAttrServlet->ServletContext replaced");
		System.out.println("BindAttrServlet->ServletContext remove");
		context.removeAttribute("context");
		System.out.println("BindAttrServlet->ServletContext removed");
		System.out.println("------------------------------------------");
		HttpSession session = req.getSession();
		System.out.println("BindAttrServlet->session add");
		session.setAttribute("session", "session...");
		System.out.println("BindAttrServlet->session added");
		System.out.println("BindAttrServlet->session replace");
		session.setAttribute("session", "session replace");
		System.out.println("BindAttrServlet->session replaced");
		System.out.println("BindAttrServlet->session remove");
		session.removeAttribute("session");
		System.out.println("BindAttrServlet->session removed");
		System.out.println("------------------------------------------");
		System.out.println("BindAttrServlet->request add");
		req.setAttribute("request", "req...");
		System.out.println("BindAttrServlet->request added");
		System.out.println("BindAttrServlet->request replace");
		req.setAttribute("request", "req replace");
		System.out.println("BindAttrServlet->request replaced");
		System.out.println("BindAttrServlet->request remove");
		req.removeAttribute("request");
		System.out.println("BindAttrServlet->request removed");
	}
}
