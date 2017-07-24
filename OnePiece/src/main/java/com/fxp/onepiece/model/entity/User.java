package com.fxp.onepiece.model.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="OP_USER",uniqueConstraints={@UniqueConstraint(columnNames="name")})
@GenericGenerator(name = "generator", strategy = "increment")
public class User {
	@Id
	@GeneratedValue(generator="generator")
	private Integer id;
	@NotEmpty
	@Column
	private String name;
	@NotEmpty
	@Column
	private String password;
	@Email
	@Column
	private String email;
	@Column(name="CREATE_TIME")
	private Date createTime;
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private Set<Conversation> conversations=new HashSet<>();
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Conversation> getConversations() {
		return conversations;
	}
	public void setConversations(Set<Conversation> conversations) {
		this.conversations = conversations;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", createTime="
				+ createTime/* + ", conversations=" + conversations */+ "]";
	}
	
}
