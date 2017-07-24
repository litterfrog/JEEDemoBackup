package com.fxp.jee.fragment.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(
		initParams={@WebInitParam(name="test1",value="123"),@WebInitParam(name="test2",value="1234")},
		loadOnStartup=0,
		urlPatterns={"/fragment","/test/fragment"}
		)
public class FragmentServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProcessRequest(req,resp);
	}
	private void ProcessRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		StringBuilder sb=new StringBuilder("initParams:");
		sb.append("test1->").append(getInitParameter("test1"))
		.append("&nbsp;&nbsp;&nbsp;&nbsp;test2->").append(getInitParameter("test2"))
		.append("<hr/>");

		
		
		req.setCharacterEncoding("UTF-8");
		Map<String, String[]> parameterMap = req.getParameterMap();
		Set<Entry<String,String[]>> set=parameterMap.entrySet();
		
		for(Entry<String,String[]> entry:set){
			sb.append("<h3>").append(entry.getKey()).append(" -> ").append(Arrays.toString(entry.getValue())).append("</h3>");
		}
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write(sb.toString());
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProcessRequest(req,resp);
	}
}
