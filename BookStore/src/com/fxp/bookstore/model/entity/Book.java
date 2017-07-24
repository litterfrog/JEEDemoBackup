package com.fxp.bookstore.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book implements Serializable {
	private static final long serialVersionUID = -917282667278830910L;
	/**
	 *  ID                                        NOT NULL NUMBER(7)
 		NAME                                      NOT NULL VARCHAR2(20)
 		INTRODUCTION                                       VARCHAR2(2000)
 		GRADE                                              NUMBER(7)
 		SELLING_PRICE                                      FLOAT(126)
 		DESCRIPTION                               NOT NULL VARCHAR2(1000)
 		PURCHASE_PRICE                            NOT NULL FLOAT(126)
 		IMAGE                                              VARCHAR2(100)
 		ISBN                                      NOT NULL VARCHAR2(20)
 		BOOK_CONCERN                              NOT NULL VARCHAR2(100)
 		PUBLISHING_DATE                           NOT NULL DATE
 		AUTHOR                                    NOT NULL VARCHAR2(20)
 		AUTHOR_INTRODUCTION                                VARCHAR2(1000)
	 */
	private int id;
	private String name;
	private String introduction;
	private String description;
	private int grade;
	private float purchasePrice;
	private float sellingPrice;
	private String image;
	private String isbn;
	private String bookConcern;
	private Date publishingDate;
	private String author;
	private String author_introduction;
	private List<BookChapter> chapters=new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public float getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(float purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public float getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookConcern() {
		return bookConcern;
	}
	public void setBookConcern(String bookConcern) {
		this.bookConcern = bookConcern;
	}
	public Date getPublishingDate() {
		return publishingDate;
	}
	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor_introduction() {
		return author_introduction;
	}
	public void setAuthor_introduction(String author_introduction) {
		this.author_introduction = author_introduction;
	}
	public List<BookChapter> getChapters() {
		return chapters;
	}
	public void setChapters(List<BookChapter> chapters) {
		this.chapters = chapters;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", introduction=" + introduction + ", description=" + description
				+ ", grade=" + grade + ", purchasePrice=" + purchasePrice + ", sellingPrice=" + sellingPrice
				+ ", image=" + image + ", isbn=" + isbn + ", bookConcern=" + bookConcern + ", publishingDate="
				+ publishingDate + ", author=" + author + ", author_introduction=" + author_introduction + ", chapters="
				+ chapters + "]";
	}
	

}
