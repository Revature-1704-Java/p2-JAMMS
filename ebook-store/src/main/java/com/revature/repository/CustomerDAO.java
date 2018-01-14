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
		return (Customer) session.get(Customer.class, id);
	}
}
