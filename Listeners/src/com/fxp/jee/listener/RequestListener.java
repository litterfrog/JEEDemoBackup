package com.fxp.jee.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		System.out.println("RequestListener requestDestroyed "+event.getServletRequest());
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		System.out.println("RequestListener requestInitialized "+event.getServletRequest());
	}

}
