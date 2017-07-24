package com.fxp.bookstore.web.listener;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import com.fxp.bookstore.common.ConnectionManager;
@WebListener
public class WebContextListener implements ServletContextListener {
	@Resource(lookup="java:/comp/env",name="jdbc/BookStore")
	private DataSource dataSource;
	@Override
	public void contextDestroyed(ServletContextEvent evt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent evt) {
		ConnectionManager.setDataSource(dataSource);

	}

}
