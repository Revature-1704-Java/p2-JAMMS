package com.revature.model;

import java.sql.Date;

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
@Table(name = "Reviews")
public class Review {

	private Integer id;
	
	private Customer customer;
	
	private Book book;
	
	private Date dateadded;
	
	private Rating rating;
	
	private String review;

	public Review(Integer id, Customer customer, Book book, Date dateadded, Rating rating, String review) {
		super();
		this.id = id;
		this.customer = customer;
		this.book = book;
		this.dateadded = dateadded;
		this.rating = rating;
		this.review = review;
	}

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReviewsSequence")
	@SequenceGenerator(allocationSize = 1, name = "ReviewsSequence", sequenceName = "seqPK_Reviews")
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

	@Column(name = "DateAdded")
	public Date getDateadded() {
		return dateadded;
	}

	public void setDateadded(Date dateadded) {
		this.dateadded = dateadded;
	}

	@OneToOne
	@JoinColumn(name = "Rating")
	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	@Column(name = "Review")
	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
	
	
}
