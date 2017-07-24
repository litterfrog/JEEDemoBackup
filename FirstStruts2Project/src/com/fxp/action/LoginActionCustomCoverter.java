package com.fxp.action;

import com.fxp.pojo.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginActionCustomCoverter extends ActionSupport {
	private User user;
	
	public String execute() throws Exception{
		System.out.println(user);
		//用于产生异常测试异常处理功能
		user.getPassword().length();
		return "success";
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
