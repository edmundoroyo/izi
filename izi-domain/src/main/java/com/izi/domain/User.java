package com.izi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="user")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	Long id;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="user")
	List<Duty> duties;
	
	@Column(name = "name", nullable = false)
	String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Duty> getDuties() {
		return duties;
	}

	public void setDuties(List<Duty> duties) {
		this.duties = duties;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
