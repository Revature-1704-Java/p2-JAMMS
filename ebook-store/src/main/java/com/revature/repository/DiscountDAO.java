package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Book;
import com.revature.model.Discount;

@Repository
@Transactional
public class DiscountDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Discount> getAllDiscounts(){
		Session session = sessionFactory.getCurrentSession();
		List<Discount> discounts = new ArrayList<>();
		discounts = session.createQuery("from Discount").list();
		
		return discounts;
	}
}
