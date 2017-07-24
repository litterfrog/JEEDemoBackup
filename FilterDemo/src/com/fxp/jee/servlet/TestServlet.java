package com.fxp.jee.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		String name=(String) session.getAttribute("user_name");
		String test=req.getParameter("test");
		resp.getWriter().write("<h3>ª∂”≠"+name+test+"∑√Œ TestServlet</h3><a href='../index.html'>∑µªÿ ◊“≥</a>");
	}
}
