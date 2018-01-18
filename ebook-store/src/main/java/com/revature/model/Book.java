package com.revature.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class Book {

	private Integer id;

	private String title;

	private Author author;

	private String description;

	private Date publishDate;

	private Double listPrice;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(Integer id, String title, Author author, String description, Date publishDate, Double listPrice) {
		super();
		this.id = id;
		this.title = title;

		this.author = author;
		this.description = description;
		this.publishDate = publishDate;
		this.listPrice = listPrice;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BooksSequence")
	@SequenceGenerator(allocationSize = 1, name = "BooksSequence", sequenceName = "seqPK_Books")
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Author")
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Column(name = "Description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Published")
	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Column(name = "Price")
	public Double getListPrice() {
		return listPrice;
	}

	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", description=" + description
				+ ", publishDate=" + publishDate + ", listPrice=" + listPrice + "]";
	}

}