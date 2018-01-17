package com.revature.repository;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Book;
import com.revature.model.Customer;
import com.revature.model.PurchasedBook;

@Repository
@Transactional
public class PurchasedBookDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	/*
	public List<Book> findPurchasedBooks(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = new ArrayList<>();
		books = session.createQuery("from PurchasedBooks P where P.Customer := custid").setParameter("custid", id).list();
		return books;
	}
	*/
	 
	public List<PurchasedBook> getAllPurchasedBook() {
		Session session = sessionFactory.getCurrentSession();
		List<PurchasedBook> pbbooks = new ArrayList<>();
		pbbooks = session.createQuery("from PurchasedBook").list();
		return pbbooks;
	}
	 
	
}