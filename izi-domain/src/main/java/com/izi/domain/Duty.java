package com.izi.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="duty")
public class Duty {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	Long id;
	
	@ManyToOne(optional = false)
	User user;
	
	@Column(name="title", nullable = false)
	String title;
	
	@Column(name="completed", nullable = false)
	Boolean completed;
	
	@Column(name="order2", nullable = false)
	Integer order;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Duty [id=" + id + ", user=" + user + ", title=" + title + ", completed=" + completed + ", order="
				+ order + "]";
	}



	
	
	
	

}
