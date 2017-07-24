package com.fxp.jee.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("WebContextListener method name:contextDestroyed");

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("WebContextListener method name:contextInitialized");

	}

}
