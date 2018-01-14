package com.jamms.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Reviews")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReviewsSequence")
	@SequenceGenerator(allocationSize = 1, name = "ReviewsSequence", sequenceName = "seqPK_Reviews")
	@Column(name = "ID")
	private Integer id;
	@OneToOne
	@Column(name = "Customer")
	private Customer reviewingCustomer;
	@OneToOne
	@Column(name = "Book")
	private Book reviewedBook;
	@Column(name = "DateAdded")
	private Date dateReviewed;
	@Column(name = "Rating")
	private Rating rating;
	@OneToOne
	@Column(name = "Review")
	private String review;

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(Integer id, Customer reviewingCustomer, Book reviewedBook, Date dateReviewed, Rating rating,
			String review) {
		super();
		this.id = id;
		this.reviewingCustomer = reviewingCustomer;
		this.reviewedBook = reviewedBook;
		this.dateReviewed = dateReviewed;
		this.rating = rating;
		this.review = review;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getReviewingCustomer() {
		return reviewingCustomer;
	}

	public void setReviewingCustomer(Customer reviewingCustomer) {
		this.reviewingCustomer = reviewingCustomer;
	}

	public Book getReviewedBook() {
		return reviewedBook;
	}

	public void setReviewedBook(Book reviewedBook) {
		this.reviewedBook = reviewedBook;
	}

	public Date getDateReviewed() {
		return dateReviewed;
	}

	public void setDateReviewed(Date dateReviewed) {
		this.dateReviewed = dateReviewed;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", reviewingCustomer=" + reviewingCustomer + ", reviewedBook=" + reviewedBook
				+ ", dateReviewed=" + dateReviewed + ", rating=" + rating + ", review=" + review + "]";
	}

}
