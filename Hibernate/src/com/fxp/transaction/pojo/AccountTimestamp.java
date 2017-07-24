package com.fxp.transaction.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class AccountTimestamp implements Serializable {
	private static final long serialVersionUID = -6522384902000945285L;
	private Long id;
	private Timestamp timestamp;
	private Long code;
	private String name;
	private Double balance;

	public AccountTimestamp(Long id, Timestamp timestamp, Long code, String name, Double balance) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.code = code;
		this.name = name;
		this.balance = balance;
	}
	public AccountTimestamp() {
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
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "AccountTimestamp [id=" + id + ", timestamp=" + timestamp + ", code=" + code + ", name=" + name
				+ ", balance=" + balance + "]";
	}

	
}
