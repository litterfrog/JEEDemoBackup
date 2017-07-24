package com.fxp.collection.set;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ItemsSet implements Serializable {
	private Integer id;
	private String name;
	private Set<String> images=new HashSet<>();
	public ItemsSet() {
		super();
	}
	public ItemsSet(Integer id, String name, Set<String> images) {
		super();
		this.id = id;
		this.name = name;
		this.images = images;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getImages() {
		return images;
	}
	public void setImages(Set<String> images) {
		this.images = images;
	}
	@Override
	public String toString() {
		return "ItemsSet [id=" + id + ", name=" + name + ", images=" + images + "]";
	}
	
}
