package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Genres")
public class Genre {
	private int id;
	private String name;
	
	
	public Genre(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Genre() {
		//super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CustomersSequence")
	@SequenceGenerator(allocationSize = 1, name = "CustomersSequence", sequenceName = "seqPK_Customers")
	@Column(name="ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="Genre")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
