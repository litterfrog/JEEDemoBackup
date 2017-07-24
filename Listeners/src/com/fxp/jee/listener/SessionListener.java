package com.fxp.jee.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("SessionListener sessionCreated "+event.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("SessionListener sessionDestroyed "+event.getSession());
	}

}
