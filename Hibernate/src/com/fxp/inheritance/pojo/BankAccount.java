package com.fxp.inheritance.pojo;

import java.util.Date;

public class BankAccount extends BillingDetails {
	private String bankName;
	private String bankSwift;
	public BankAccount(Long id, String owner, String code, Date created, String bankName, String bankSwift) {
		super(id, owner, code, created);
		this.bankName = bankName;
		this.bankSwift = bankSwift;
	}
	public BankAccount(Long id, String owner, String code, Date created) {
		super(id, owner, code, created);
	}
	public BankAccount(){
		super();
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankSwift() {
		return bankSwift;
	}
	public void setBankSwift(String bankSwift) {
		this.bankSwift = bankSwift;
	}
	@Override
	public String toString() {
		return "BankAccount [bankName=" + bankName + ", bankSwift=" + bankSwift + "]";
	}
	
}
