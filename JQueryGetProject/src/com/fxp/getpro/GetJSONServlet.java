package com.fxp.getpro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetJSONServlet
 */
@WebServlet("/GetJSONServlet")
public class GetJSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");//告知浏览器数据类型为xml，用utf-8来解析
		response.setCharacterEncoding("utf-8");//response对象中的数据以utf-8解码后再发向浏览器
		PrintWriter out=response.getWriter();
		out.println("{\"students\":[{\"name\":\"cat\",\"age\":1},{\"name\":\"dog\",\"age\":3}]}");
		out.close();
	}



}
