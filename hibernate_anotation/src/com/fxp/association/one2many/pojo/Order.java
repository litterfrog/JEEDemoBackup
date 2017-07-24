package com.fxp.association.one2many.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="t_order")
@SequenceGenerator(name="sequence",sequenceName="t_order_seq",allocationSize=1)
public class Order implements Serializable {
	private static final long serialVersionUID = -955417654604705002L;
	private Long id;
	private Date orderedDate;
	private Date shippedDate;
	private Double total;
	private Set<OrderLine> orderlines=new HashSet<OrderLine>();
	public Order(Long id, Date orderedDate, Date shippedDate, Double total, Set<OrderLine> orderlines) {
		super();
		this.id = id;
		this.orderedDate = orderedDate;
		this.shippedDate = shippedDate;
		this.total = total;
		this.orderlines = orderlines;
	}
	public Order() {
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
	@Column(name="ordered_date")
	public Date getOrderedDate() {
		return orderedDate;
	}	
	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}
	@Column(name="Shipped_date")
	public Date getShippedDate() {
		return shippedDate;
	}
	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
	public Set<OrderLine> getOrderlines() {
		return orderlines;
	}
	public void setOrderlines(Set<OrderLine> orderlines) {
		this.orderlines = orderlines;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderedDate=" + orderedDate + ", shippedDate=" + shippedDate + ", total=" + total
				+ ", orderlines=" + orderlines + "]";
	}
	
}
