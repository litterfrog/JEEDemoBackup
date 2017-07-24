package com.fxp.collection.map;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ItemsMap implements Serializable {
	private static final long serialVersionUID = 6473124864857131179L;
	private Integer id;
	private String name;
	private Map<String,String> images=new HashMap<>();
	public ItemsMap() {
		super();
	}
	public ItemsMap(Integer id, String name, Map<String,String> images) {
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
	public Map<String,String> getImages() {
		return images;
	}
	public void setImages(Map<String,String> images) {
		this.images = images;
	}
	@Override
	public String toString() {
		return "ItemsSet [id=" + id + ", name=" + name + ", images=" + images + "]";
	}
	
}
