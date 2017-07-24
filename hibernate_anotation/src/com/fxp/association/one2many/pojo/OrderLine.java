package com.fxp.association.one2many.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="t_orderline")
@SequenceGenerator(name="sequence",sequenceName="t_orderline_seq",allocationSize=1)
public class OrderLine implements Serializable {
	private static final long serialVersionUID = -8010073046762438775L;
	private Long id;
	private Double price;
	private Long quantity;
	private String product;
	private Order order;
	public OrderLine(Long id, Double price, Long quantity, String product, Order order) {
		super();
		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.product = product;
		this.order = order;
	}
	public OrderLine() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sequence")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	@ManyToOne
	@JoinColumn(name="order_id")
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", price=" + price + ", quantity=" + quantity + ", product=" + product + "]";
	}
	
}
