package com.fxp.basic.pojo;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 8879566007748119407L;
	private Long id;//attribute
	private String name;
	private String address;
	private String gender;
	private Integer age;
	
	
	public Student() {
		super();
	}
	public Student(Long id, String name, String address, String gender, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.gender = gender;
		this.age = age;
	}
	//配置文件中的property,只与get,set后面的名称有关
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", gender=" + gender + ", age=" + age
				+ "]";
	}
	
	
	
}
