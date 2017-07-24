package com.fxp.jee.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session=event.getSession();
		ServletContext servletContext = session.getServletContext();
		Integer number=(Integer)servletContext.getAttribute("total");
		if(number==null){
			servletContext.setAttribute("total", 1);
		}else{
			servletContext.setAttribute("total", ++number);
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session=event.getSession();
		ServletContext servletContext = session.getServletContext();
		Integer number=(Integer)servletContext.getAttribute("total");
		servletContext.setAttribute("total", --number);
	}

}
