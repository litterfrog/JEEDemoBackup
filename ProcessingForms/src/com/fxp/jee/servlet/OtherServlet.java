package com.fxp.jee.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OtherServlet extends HttpServlet {
	private static final long serialVersionUID = 8841487737742951612L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String hidden=req.getParameter("hidden");
		String gender=req.getParameter("gender");
		String city=req.getParameter("city");
		String[] courses=req.getParameterValues("course");
		
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write("hidden:"+hidden+"<br/>gender:"+gender+"<br/>city:"+city
				+"<br/>courses:"+Arrays.toString(courses));
	}
}
