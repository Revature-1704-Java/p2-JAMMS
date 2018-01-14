package com.jamms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Carts")
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CartsSequence")
	@SequenceGenerator(allocationSize = 1, name = "CartsSequence", sequenceName = "seqPK_Carts")
	@Column(name = "ID")
	private Integer id;
	@OneToOne
	@Column(name = "Customer")
	private Customer customer;
	@OneToOne
	@Column(name = "Book")
	private Book book;

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItem(Integer id, Customer customer, Book book) {
		super();
		this.id = id;
		this.customer = customer;
		this.book = book;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "CartContents [id=" + id + ", customer=" + customer + ", book=" + book + "]";
	}
}
