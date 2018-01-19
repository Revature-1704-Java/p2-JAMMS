package com.revature.model;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {
	
	private Integer id;
	private String username;
	private String password;
	private String email;
	
	public Customer(Integer id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
	public Customer() {
		
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CustomersSequence")
	@SequenceGenerator(allocationSize = 1, name = "CustomersSequence", sequenceName = "seqPK_Customers")
	@Column(name="ID")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="USERNAME", unique=true)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}
	
}
