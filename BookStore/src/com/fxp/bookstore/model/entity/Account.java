package com.fxp.bookstore.model.entity;

import java.io.Serializable;
import java.util.List;

public class Account implements Serializable {
	private static final long serialVersionUID = 7313441051332326166L;
	private int id;
	private String account;
	private String password;
	private String email;
	private int integral;
	private List<Consignee> consignees;
	public List<Consignee> getConsignees() {
		return consignees;
	}
	public void setConsignees(List<Consignee> consignees) {
		this.consignees = consignees;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", account=" + account + ", password=" + password + ", email=" + email
				+ ", integral=" + integral + "]";
	}
	
	
}
