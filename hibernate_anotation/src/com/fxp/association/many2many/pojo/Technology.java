package com.fxp.association.many2many.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="t_Technology")
@SequenceGenerator(name="seq",allocationSize=1,sequenceName="t_Technology_seq")
public class Technology implements Serializable {
	private Long id;
	private String name;
	private String category;
	private Set<Engineer> engineers=new HashSet<>();
	public Technology(Long id, String name, String category, Set<Engineer> engineers) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.engineers = engineers;
	}
	public Technology() {
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@ManyToMany(mappedBy="technologies")
	public Set<Engineer> getEngineers() {
		return engineers;
	}
	public void setEngineers(Set<Engineer> engineers) {
		this.engineers = engineers;
	}
	@Override
	public String toString() {
		return "Technology [id=" + id + ", name=" + name + ", category=" + category + "]";
	}
	
}
