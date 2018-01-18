package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

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
	public CustomerDAO() {}

	@Autowired
	private SessionFactory sessionFactory;

	public Customer findCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();

		Customer c = session.get(Customer.class, id);
		if (c == null) {
			System.out.println("Customer is null");
		}
		return c;
	}

	public Customer findCustomer(String username) {
		Session session = sessionFactory.getCurrentSession();

		Customer c = session.get(Customer.class, username);
		if (c == null) {
			System.out.println("Customer is null");
		}
		return c;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomer() {
		Session session = sessionFactory.getCurrentSession();
		List<Customer> customers = new ArrayList<>();
		customers = session.createQuery("from Customer").list();

		return customers;
	}

}
