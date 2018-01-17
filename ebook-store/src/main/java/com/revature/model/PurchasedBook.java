package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PurchasedBooks")
public class PurchasedBook {

	private Integer id;
	private Customer customer;
	private Book book;
	private Double price;
	
	public PurchasedBook(Integer id, Customer customer, Book book, Double price) {
		super();
		this.id = id;
		this.customer = customer;
		this.book = book;
		this.price = price;
	}

	public PurchasedBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PurchasedBooksSequence")
	@SequenceGenerator(allocationSize = 1, name = "PurchasedBooksSequence", sequenceName = "seqPK_PurchasedBooks")
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name = "Customer")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@OneToOne
	@JoinColumn(name = "Book")
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Column(name = "Price")
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}
