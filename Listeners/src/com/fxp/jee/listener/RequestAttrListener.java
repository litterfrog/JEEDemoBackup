package com.fxp.jee.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class RequestAttrListener implements ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent event) {
		System.out.println("RequestAttrListener attributeAdded name:"+event.getName()+" value:"+event.getValue());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent event) {
		System.out.println("RequestAttrListener attributeRemoved name:"+event.getName()+" value:"+event.getValue());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent event) {
		System.out.println("RequestAttrListener attributeReplaced name:"+event.getName()+" value:"+event.getValue());
	}

}
