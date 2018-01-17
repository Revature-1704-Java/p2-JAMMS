package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Flags")
public class Flag {

	private Integer id;
	private String flag;
	
	public Flag(Integer id, String flag) {
		super();
		this.id = id;
		this.flag = flag;
	}

	public Flag() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Flag")
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	
	
}
