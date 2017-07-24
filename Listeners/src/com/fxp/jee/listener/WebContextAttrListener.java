package com.fxp.jee.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class WebContextAttrListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("WebContextAttrListener attributeAdded name:"+event.getName()+" value:"+event.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("WebContextAttrListener attributeRemoved name:"+event.getName()+" value:"+event.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("WebContextAttrListener attributeReplaced name:"+event.getName()+" value:"+event.getValue());
	}

}
