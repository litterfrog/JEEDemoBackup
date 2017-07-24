package com.fxp.action;

import java.util.List;
import java.util.Map;

import com.fxp.pojo.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction{
	private Map<String,User> usersMap;
	private List<User> usersList;
	
	public String execute() throws Exception{
//		System.out.println(usersMap);
//		System.out.println(usersList);
		if(usersMap.get("a").getName().equals("fxp")&&usersMap.get("a").getPassword().equals("fxp")){
			ActionContext.getContext().getSession().put("user", usersMap.get("a"));
//			ActionContext.getContext().getSession().clear();
			return "success";
		}else{
			return "input";
		}
		
		
	}

	public Map<String, User> getUsersMap() {
		return usersMap;
	}

	public void setUsersMap(Map<String, User> users) {
		this.usersMap = users;
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}
	
}
