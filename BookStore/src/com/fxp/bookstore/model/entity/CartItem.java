package com.fxp.bookstore.model.entity;

import java.io.Serializable;

public class CartItem implements Serializable {
	
	private Book book;
	private int quantity=1;	
	
	public CartItem() {
	}
	public CartItem(Book book) {
		this.book = book;
	}
	public CartItem(Book book, int quantity) {
		this.book = book;
		this.quantity = quantity;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTotal(){
		return book.getSellingPrice()*quantity;
	}
}
