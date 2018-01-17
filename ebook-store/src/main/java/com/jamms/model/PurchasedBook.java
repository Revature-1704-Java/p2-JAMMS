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
@Table(name = "PurchasedBooks")
public class PurchasedBook {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PurchaseBooksSequence")
	@SequenceGenerator(allocationSize = 1, name = "PurchasedBooksSequence", sequenceName = "seqPK_PurchasedBooks")
	@Column(name = "ID")
	private Integer id;
	@OneToOne
	@Column(name = "Customer")
	private Customer customer;
	@OneToOne
	@Column(name = "Book")
	private Book book;
	@Column(name = "Price")
	private Double purchasePrice;

	public PurchasedBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchasedBook(Integer id, Customer customer, Book book, Double purchasePrice) {
		super();
		this.id = id;
		this.customer = customer;
		this.book = book;
		this.purchasePrice = purchasePrice;
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

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	@Override
	public String toString() {
		return "PurchasedBook [id=" + id + ", customer=" + customer + ", book=" + book + ", purchasePrice="
				+ purchasePrice + "]";
	}
}
