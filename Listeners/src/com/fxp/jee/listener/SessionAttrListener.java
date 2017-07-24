package com.fxp.jee.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttrListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("SessionAttrListener attributeAdded name:"+event.getName()+" value:"+event.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("SessionAttrListener attributeRemoved name:"+event.getName()+" value:"+event.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("SessionAttrListener attributeReplaced name:"+event.getName()+" value:"+event.getValue());
	}

}
