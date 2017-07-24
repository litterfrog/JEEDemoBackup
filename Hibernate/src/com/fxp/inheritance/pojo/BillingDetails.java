package com.fxp.inheritance.pojo;

import java.io.Serializable;
import java.util.Date;

public abstract class BillingDetails implements Serializable {
	private static final long serialVersionUID = -8924301233071471413L;
	private Long id;
	private String owner;
	private String code;
	private Date created;
	public BillingDetails(Long id, String owner, String code, Date created) {
		super();
		this.id = id;
		this.owner = owner;
		this.code = code;
		this.created = created;
	}
	public BillingDetails() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "BillingDetails [id=" + id + ", owner=" + owner + ", code=" + code + ", created=" + created + "]";
	}
	
}
