package com.fxp.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.fxp.pojo.User;

public class UserConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		User user=new User();
		String[] userValues=arg1[0].split(",");
		user.setName(userValues[0]);
		user.setPassword(userValues[1]);
		return user;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		User user=(User)arg1;
		return "["+user.getName()+","+user.getPassword()+"]";
	}

}
