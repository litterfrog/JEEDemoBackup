package com.fxp.jee.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginValidationFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
			HttpServletRequest request=(HttpServletRequest)req;
			HttpServletResponse res=(HttpServletResponse) resp;
			HttpSession session=request.getSession(false);
			if(session==null||session.getAttribute("user_name")==null){
				res.sendRedirect("../login.html");
			}else{
				res.setContentType("text/html;charset=UTF-8");//解决乱码，在chain.doFilter调用之前设置才有效
				chain.doFilter(req, resp);
				
			}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
