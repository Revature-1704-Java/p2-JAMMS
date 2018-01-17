package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Customer;
import com.revature.model.Review;

@Repository
@Transactional
public class ReviewDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Review> getAllReviews(){
		Session session = sessionFactory.getCurrentSession();
		List<Review> reviews = new ArrayList<>();
		reviews = session.createQuery("from Review").list();
		
		return reviews;
	}
}
