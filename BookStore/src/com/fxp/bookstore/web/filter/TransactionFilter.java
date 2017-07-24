package com.fxp.bookstore.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.fxp.bookstore.common.TransactionManager;
@WebFilter("/do/*")
public class TransactionFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		try {
			TransactionManager.begin();
			chain.doFilter(req, resp);
			TransactionManager.commit();
		} catch (Exception e) {
			TransactionManager.rollback();
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}

}
