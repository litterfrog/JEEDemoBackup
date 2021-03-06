package com.fxp.springmvc.crud.entities;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class Employee {

	public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.department = department;
	}
	public Employee() {
	}
	private Integer id;
	//不能修改
	@NotEmpty
	private String lastName;
	@Email
	private String email;
	//从前端传入的是String类型，所以需要注意转换类型
	private Integer gender;
	@Past
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;
	@NumberFormat(pattern="#,###,###.#")
	private Float salary;
//	双向n-1的关联关系
	private Department department;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + ", birth="
				+ birth + ", salary=" + salary + ", department=" + department + "]";
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	
}
