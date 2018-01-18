package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ratings")
public class Rating {
	private Integer id;
	private Integer rating;

	public Rating(Integer id, Integer rating) {
		super();
		this.id = id;
		this.rating = rating;
	}

	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Rating")
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
