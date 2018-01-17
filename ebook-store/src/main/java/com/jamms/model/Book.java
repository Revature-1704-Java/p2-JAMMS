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
@Table(name = "Books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BooksSequence")
	@SequenceGenerator(allocationSize = 1, name = "BooksSequence", sequenceName = "seqPK_Books")
	@Column(name = "ID")
	private Integer id;
	@Column(name = "Title")
	private String title;
	@OneToOne
	@Column(name = "Author")
	private Author author;
	@Column(name = "Description")
	private String description;
	@Column(name = "Published")
	private Date publishDate;
	@Column(name = "Price")
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

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
