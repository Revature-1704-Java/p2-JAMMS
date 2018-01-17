package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Book;



@Repository
@Transactional
public class BookDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Book findBook(Integer id) {
		Book b = null;
		Session session = sessionFactory.getCurrentSession();
		b =  (Book) session.get(Book.class, id);
		if(b == null) {
			System.out.println("Book is null");
		}
		return b;
	}
	
	
	public void saveBook(Book b) {
		Session session = sessionFactory.getCurrentSession();
		session.save(b);
		session.close();
	}
	
	public void deleteBook(Book b) {
		
	}
	
	public List<Book> getAllBooks(){
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = new ArrayList<>();
		books = session.createQuery("from Book").list();
		session.close();
		
		return books;
	}
}
