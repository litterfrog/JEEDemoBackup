package com.fxp.transaction.pojo;

import java.io.Serializable;

public class Account implements Serializable {
	private static final long serialVersionUID = -6522384902000945285L;
	private Long id;
	private Long code;
	private String name;
	private Double balance;
	public Account(Long id, Long code, String name, Double balance) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.balance = balance;
	}
	public Account() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", code=" + code + ", name=" + name + ", balance=" + balance + "]";
	}
	
}
