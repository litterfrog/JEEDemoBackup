package com.fxp.getpro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetXMLServlet
 */
@WebServlet("/GetXMLServlet")
public class GetXMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=utf-8");//告知浏览器数据类型为xml，用utf-8来解析
		response.setCharacterEncoding("utf-8");//response对象中的数据以utf-8解码后再发向浏览器
		PrintWriter out=response.getWriter();
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		StringBuilder xml=new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
		xml.append("<student>")
		.append("<name>"+username+"</name>")
		.append("<password>"+password+"</password>")
		.append("</student>");
		out.println(xml.toString());
		out.close();
	}


}
