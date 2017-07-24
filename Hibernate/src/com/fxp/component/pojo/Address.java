package com.fxp.component.pojo;

import java.io.Serializable;

public class Address implements Serializable {
	private String province;
	private String city;
	private String street;
	private Customer customer;
	public Address(String province, String city, String street) {
		super();
		this.province = province;
		this.city = city;
		this.street = street;
	}
	public Address() {
		super();
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Address [province=" + province + ", city=" + city + ", street=" + street + "]";
	}
	
}
