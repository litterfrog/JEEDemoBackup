package com.fxp.association.many2many.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="t_engineer")
@SequenceGenerator(name="seq",allocationSize=1,sequenceName="t_engineer_seq")
public class Engineer implements Serializable {
	private Long id;
	private String name;
	private String gender;
	private Integer age;
	private String company;
	private Set<Technology> technologies=new HashSet<>();
	public Engineer(Long id, String name, String gender, Integer age, String company, Set<Technology> technologies) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.company = company;
		this.technologies = technologies;
	}
	public Engineer() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="t_engineer_technology",
			   joinColumns={@JoinColumn(name="engineer_id")},
			   inverseJoinColumns={@JoinColumn(name="technology_id")}
			)
	public Set<Technology> getTechnologies() {
		return technologies;
	}
	public void setTechnologies(Set<Technology> technologies) {
		this.technologies = technologies;
	}
	@Override
	public String toString() {
		return "Engineer [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", company=" + company
				+ ", technologies=" + technologies + "]";
	}
	
}
