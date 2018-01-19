package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Customer;

@Repository
@Transactional
public class CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Customer findCustomer(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "FROM Customer c WHERE c.username LIKE :username and c.password like :password";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password", password);
		List<Customer> customers = query.list();
		
		return customers.size()>0?customers.get(0):null;
	}

	public Customer findCustomer(String username) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "Select from Customer c where c.id=" + username;
		Customer c = (Customer) session.createQuery(hql);
		if (c == null) {
			System.out.println("Customer is null");
		}
		return c;
	}

	public Customer getCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();

		Customer c = session.get(Customer.class, id);
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
