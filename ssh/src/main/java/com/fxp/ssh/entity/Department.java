package com.fxp.ssh.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="SSH_DEPARTMENT")
@GenericGenerator(name = "generator", strategy = "increment")
public class Department {
	
	@Id
	@GeneratedValue(generator="generator")
	private Integer id;
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;
	@OneToMany(mappedBy="department",cascade=CascadeType.ALL)
	private Set<Employee> emps=new HashSet<>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Set<Employee> getEmps() {
		return emps;
	}
	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}
	
}
