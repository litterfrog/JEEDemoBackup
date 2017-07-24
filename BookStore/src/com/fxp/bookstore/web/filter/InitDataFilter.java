package com.fxp.bookstore.web.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.fxp.bookstore.common.ConnectionManager;
import com.fxp.bookstore.model.entity.Book;
import com.fxp.bookstore.model.service.ServiceFactory;
@WebFilter("/index.jsp")
public class InitDataFilter implements Filter {

	@Override
	public void destroy() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doFilter");
		List<Book> books=ServiceFactory.getService("book").findAll();
		ConnectionManager.release();
		req.setAttribute("books", books);
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
