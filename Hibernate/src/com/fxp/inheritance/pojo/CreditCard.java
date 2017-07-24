package com.fxp.inheritance.pojo;

import java.util.Date;

public class CreditCard extends BillingDetails {
	private static final long serialVersionUID = -249463762527982178L;
	private String type;
	private String expMonth;
	private String expYear;
	public CreditCard(Long id, String owner, String code, Date created, String type, String expMonth, String expYear) {
		super(id, owner, code, created);
		this.type = type;
		this.expMonth = expMonth;
		this.expYear = expYear;
	}
	public CreditCard(Long id, String owner, String code, Date created) {
		super(id, owner, code, created);
	}
	public CreditCard() {
		super();
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExpMonth() {
		return expMonth;
	}
	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}
	public String getExpYear() {
		return expYear;
	}
	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}
	@Override
	public String toString() {
		return "CreditCard [type=" + type + ", expMonth=" + expMonth + ", expYear=" + expYear + "]";
	}
	
}
