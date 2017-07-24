package com.fxp.onepiece.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="OP_CONVERSATION")
@GenericGenerator(name = "generator", strategy = "increment")
public class Conversation {
	@Id
	@GeneratedValue(generator="generator")
	private Long id;
	@Column
	private String message;
	@Column(name="CREATE_TIME")
	private Date createTime;
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Conversation [id=" + id + ", message=" + message + ", createTime=" + createTime
				+ "]";
	}

}
