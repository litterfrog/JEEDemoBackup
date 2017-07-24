package com.fxp.collection.bag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ItemsBag implements Serializable {
	private static final long serialVersionUID = -7596049410785767030L;
	private Integer id;
	private String name;
	private List<String> images=new ArrayList<>();
	public ItemsBag() {
		super();
	}
	public ItemsBag(Integer id, String name, List<String> images) {
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
