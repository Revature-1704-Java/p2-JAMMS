package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Book_Genre;
import com.revature.model.Cart;

@Repository
@Transactional
public class Book_GenreDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//functions to implement: given an book id, return all genres
	
	public List<Book_Genre> getAllBookGenre(){
		Session session = sessionFactory.getCurrentSession();
		List<Book_Genre> bookgenre = new ArrayList<>();
		bookgenre = session.createQuery("from Book_Genre").list();
		
		return bookgenre;
	}
}
