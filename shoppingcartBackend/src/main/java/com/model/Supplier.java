package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity 
@Table(name="supplier")
@Component
public class Supplier {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sId")
	int id;
	
	@Column(name="sName")
	 String sname;
	
	@Column(name="sLocation")
	 String slocation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSlocation() {
		return slocation;
	}

	public void setSlocation(String slocation) {
		this.slocation = slocation;
	}
	
	}
