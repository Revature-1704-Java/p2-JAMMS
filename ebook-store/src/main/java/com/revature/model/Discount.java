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
@Table(name = "Discounts")
public class Discount {

	private Integer id;
	private Book book;
	private double discount;
	private Date startdate;
	private Date enddate;
	
	public Discount(Integer id, Book book, double discount, Date startdate, Date enddate) {
		super();
		this.id = id;
		this.book = book;
		this.discount = discount;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public Discount() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DiscountsSequence")
	@SequenceGenerator(allocationSize = 1, name = "DiscountsSequence", sequenceName = "seqPK_Discounts")
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	@OneToOne
	@JoinColumn(name = "Book")
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Column(name = "Discount")
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Column(name = "Startdate")
	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	@Column(name = "Enddate")
	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
	
}
