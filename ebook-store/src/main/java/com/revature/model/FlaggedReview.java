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
@Table(name = "FlaggedReviews")
public class FlaggedReview {

	private Integer id;
	
	private Customer flaggedCustomer;
	
	private Review flaggedReview;
	
	private Flag flag;

	public FlaggedReview(Integer id, Customer flaggedCustomer, Review flaggedReview, Flag flag) {
		super();
		this.id = id;
		this.flaggedCustomer = flaggedCustomer;
		this.flaggedReview = flaggedReview;
		this.flag = flag;
	}

	public FlaggedReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FlaggedReviewsSequence")
	@SequenceGenerator(allocationSize = 1, name = "FlaggedReviewsSequence", sequenceName = "seqPK_FlaggedReviews")
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name = "Customer")
	public Customer getFlaggedCustomer() {
		return flaggedCustomer;
	}

	public void setFlaggedCustomer(Customer flaggedCustomer) {
		this.flaggedCustomer = flaggedCustomer;
	}

	@OneToOne
	@JoinColumn(name = "Review")
	public Review getFlaggedReview() {
		return flaggedReview;
	}

	public void setFlaggedReview(Review flaggedReview) {
		this.flaggedReview = flaggedReview;
	}

	@OneToOne
	@JoinColumn(name = "Flag")
	public Flag getFlag() {
		return flag;
	}

	public void setFlag(Flag flag) {
		this.flag = flag;
	}
		
	
}
