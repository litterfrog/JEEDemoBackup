package com.fxp.collection.list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ItemsList implements Serializable {
	private static final long serialVersionUID = 7778087165995465348L;
	private Integer id;
	private String name;
	private List<String> images=new ArrayList<>();
	public ItemsList() {
		super();
	}
	public ItemsList(Integer id, String name, List<String> images) {
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
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	@Override
	public String toString() {
		return "ItemsSet [id=" + id + ", name=" + name + ", images=" + images + "]";
	}
	
}
