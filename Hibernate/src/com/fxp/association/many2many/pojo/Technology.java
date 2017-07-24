package com.fxp.association.many2many.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
