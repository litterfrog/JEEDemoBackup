package com.fxp.bookstore.model.entity;

import java.io.Serializable;

public class OrderItem implements Serializable {
	private static final long serialVersionUID = 4932329718931143519L;
	private int orderId;
	private int bookId;
	private int quantity;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
