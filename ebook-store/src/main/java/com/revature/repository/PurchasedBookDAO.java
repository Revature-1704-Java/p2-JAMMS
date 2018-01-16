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

//@Repository
//@Transactional
public class PurchasedBookDAO {
	
	
	/*@Autowired
	private SessionFactory sessionFactory;
	
	public List<Book> findPurchasedBooks(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = new ArrayList<>();
		books = session.createQuery("from PurchasedBooks P where P.Customer := custid").setParameter("custid", id).list();
		return books;
	}
	*/
	/*
	 * 
	 * public void insertCustomer() {
		Session session = sessionFactory.getCurrentSession();
		Customer c = new Customer();
		c.setId(1);
		c.setUsername("samy");
		c.setEmail("s@email.com");
		c.setPassword("asde");
		
		
		int result = (int)session.save(c);
		tx.commit();
		session.close();
		return result;
	}
	 * 
	 * 
	 * 
	 */
	
}