package com.revature.repository;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Customer;

@Repository
@Transactional
public class CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Customer findCustomer(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		
		Customer c =  (Customer) session.get(Customer.class, id);
		if(c == null) {
			System.out.println("Customer is null");
		}
		return c;
	}
	
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
