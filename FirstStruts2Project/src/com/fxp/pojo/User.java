package com.fxp.pojo;

import java.util.Date;

public class User {
	private String name;
	private String password;
	private int age;
	private Date registerDate;
	
	public User() {
		super();
	}
	public User(String name, String password, int age, Date registerDate) {
		super();
		this.name = name;
		this.password = password;
		this.age = age;
		this.registerDate = registerDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", age=" + age + ", registerDate=" + registerDate
				+ "]";
	}
	
}
