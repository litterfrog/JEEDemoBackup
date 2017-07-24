package com.fxp.jee.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LifeCycleFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
		print("init");

	}
	void print(String info){
		System.out.println(info+" thread name:"+Thread.currentThread().getName());
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		print("doFilter");
		chain.doFilter(req, resp);
		print("chain doFilter end");
	}
	@Override
	public void destroy() {
		print("destroy");

	}

}
