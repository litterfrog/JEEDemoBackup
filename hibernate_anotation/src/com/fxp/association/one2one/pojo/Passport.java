package com.fxp.association.one2one.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
//@Table(name="t_passport_fk")
//@SequenceGenerator(name="sequence",sequenceName="t_passport_fk_seq")
@Table(name="t_passport_pk")
public class Passport implements Serializable {
	private Long id;
	private String bh;
	private Person person;
	public Passport(Long id, String bh, Person person) {
		super();
		this.id = id;
		this.bh = bh;
		this.person = person;
	}
	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GenericGenerator(strategy="foreign", name = "pkGenerator",parameters={@Parameter(name="property",value="person")})
	@GeneratedValue(generator="pkGenerator")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBh() {
		return bh;
	}
	public void setBh(String bh) {
		this.bh = bh;
	}
	@OneToOne(mappedBy="passport",cascade=CascadeType.ALL)
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "Passport [id=" + id + ", bh=" + bh + "]";
	}
	
}
