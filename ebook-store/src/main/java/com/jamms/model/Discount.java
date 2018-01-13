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
@Table(name = "Discounts")
public class Discount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DiscountsSequence")
	@SequenceGenerator(allocationSize = 1, name = "DiscountsSequence", sequenceName = "seqPK_Discounts")
	@Column(name = "ID")
	private Integer id;
	@OneToOne
	@Column(name = "Book")
	private Book book;
	@Column(name = "Discount")
	private Double discountedPrice;
	@Column(name = "StartDate")
	private Date startDate;
	@Column(name = "EndDate")
	private Date endDate;

	public Discount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Discount(Integer id, Book book, Double discountedPrice, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.book = book;
		this.discountedPrice = discountedPrice;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Discount [id=" + id + ", book=" + book + ", discountedPrice=" + discountedPrice + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
}
