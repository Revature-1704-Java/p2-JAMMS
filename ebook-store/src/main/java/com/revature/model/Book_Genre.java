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
@Table(name = "Book_Genre")
public class Book_Genre {
	private int id;
	private Book book;
	private Genre genre;
	public Book_Genre(int id, Book book, Genre genre) {
		super();
		this.id = id;
		this.book = book;
		this.genre = genre;
	}
	public Book_Genre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CustomersSequence")
	@SequenceGenerator(allocationSize = 1, name = "CustomersSequence", sequenceName = "seqPK_Customers")
	@Column(name="ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
	@OneToOne
	@JoinColumn(name = "Genre")
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	
}

	
	