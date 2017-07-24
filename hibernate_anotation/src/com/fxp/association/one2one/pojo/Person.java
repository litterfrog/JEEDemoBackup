package com.fxp.association.one2one.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@Table(name="t_person_fk")
//@SequenceGenerator(name="sequence",sequenceName="t_person_fk_seq")
@Table(name="t_person_pk")
@SequenceGenerator(name="sequence",sequenceName="t_person_pk_seq")
public class Person implements Serializable {
	private Long id;
	private String name;
	private String gender;
	private Integer age;
	private Passport passport;
	public Person(Long id, String name, String gender, Integer age, Passport passport) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.passport = passport;
	}
	public Person() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sequence")
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
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn//Éú³ÉIDÒ»¶Ë
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", passport=" + passport
				+ "]";
	}
	
}
