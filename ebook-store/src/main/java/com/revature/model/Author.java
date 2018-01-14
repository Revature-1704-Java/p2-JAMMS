package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Authors")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AuthorsSequence")
	@SequenceGenerator(allocationSize = 1, name = "AuthorsSequence", sequenceName = "seqPK_Authors")
	@Column(name = "ID")
	private Integer id;
	@Column(name = "FirstName")
	private String firstName;
	@Column(name = "LastName")
	private String lastName;

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(Integer id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
