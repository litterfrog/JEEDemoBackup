package com.fxp.jee.filter;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter("/*")
public class TestFilter implements Filter {
	private @Resource(name="test")String str;
	@Override
	public void destroy() {
		System.out.println("TestFilter destroy");

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("TestFilter doFilter");
		System.out.println("FilterChain doFilter start");
		arg2.doFilter(arg0, arg1);
		System.out.println("FilterChain doFilter end");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("TestFilter init");
		System.out.println("test ×¢½â resource:"+str);
	}

}
