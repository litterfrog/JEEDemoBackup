package com.fxp.transaction.pojo;

import java.io.Serializable;

public class AccountVersion implements Serializable {
	private static final long serialVersionUID = -7319073305320586908L;
	private Long id;
	private Long version;
	private Long code;
	private String name;
	private Double balance;

	public AccountVersion(Long id, Long version, Long code, String name, Double balance) {
		super();
		this.id = id;
		this.version = version;
		this.code = code;
		this.name = name;
		this.balance = balance;
	}
	public AccountVersion() {
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
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "AccountVersion [id=" + id + ", version=" + version + ", code=" + code + ", name=" + name + ", balance="
				+ balance + "]";
	}
	
}
