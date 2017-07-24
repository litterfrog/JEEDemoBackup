package com.fxp.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TagAction extends ActionSupport {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	public String process() throws Exception{
		ActionContext.getContext().put("msg", this.getMsg());
		return SUCCESS;
	}
}
