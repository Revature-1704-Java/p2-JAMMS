package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FlaggedReviews")
public class FlaggedReview {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FlaggedReviewsSequence")
	@SequenceGenerator(allocationSize = 1, name = "FlaggedReviewsSequence", sequenceName = "seqPK_FlaggedReviews")
	@Column(name = "ID")
	private Integer id;
	@OneToOne
	@Column(name = "Customer")
	private Customer flaggingCustomer;
	@OneToOne
	@Column(name = "Review")
	private Review flaggedReview;
	@Column(name = "Flag")
	private Flag flag;

	public FlaggedReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlaggedReview(Integer id, Customer flaggingCustomer, Review flaggedReview, Flag flag) {
		super();
		this.id = id;
		this.flaggingCustomer = flaggingCustomer;
		this.flaggedReview = flaggedReview;
		this.flag = flag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getFlaggingCustomer() {
		return flaggingCustomer;
	}

	public void setFlaggingCustomer(Customer flaggingCustomer) {
		this.flaggingCustomer = flaggingCustomer;
	}

	public Review getFlaggedReview() {
		return flaggedReview;
	}

	public void setFlaggedReview(Review flaggedReview) {
		this.flaggedReview = flaggedReview;
	}

	public Flag getFlag() {
		return flag;
	}

	public void setFlag(Flag flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "FlaggedReview [id=" + id + ", flaggingCustomer=" + flaggingCustomer + ", flaggedReview=" + flaggedReview
				+ ", flag=" + flag + "]";
	}

}
