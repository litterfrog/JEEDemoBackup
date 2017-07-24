package com.fxp.ssh.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ssh_employee")
@GenericGenerator(name = "generator", strategy = "increment")
public class Employee {
	@Id
	@GeneratedValue(generator="generator")
	private Integer id;
	//不能修改
	@Column(name="LAST_NAME")
	private String lastName;
	@Column
	private String email;
	//从前端传入的是String类型，所以需要注意转换类型
	@Column
	private Date birth;
	//不能修改
	@Column(name="CREATE_TIME")
	private Date createTime;
//	双向n-1的关联关系
	@ManyToOne
	@JoinColumn(name="dept_id")
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
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
