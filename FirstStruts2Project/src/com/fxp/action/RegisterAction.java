package com.fxp.action;

import com.fxp.pojo.User;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
	private User user;
	
	@Override
	public String execute() throws Exception {
		System.out.println(user);
		return SUCCESS;
	}	
	
	@Override
	public void validate() {
		if(user.getName().contains("admin")){
			this.addFieldError("user.name", "�û������ܰ���admin");
		}
		if(user.getPassword().contains("1234")){
			this.addFieldError("user.password", "���������ˣ�����");
		}
	}

	//getter setter �Ǳ�Ҫ��
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}



	
}
