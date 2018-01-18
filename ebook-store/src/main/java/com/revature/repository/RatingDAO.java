package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Rating;

@Repository
@Transactional
public class RatingDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Rating> getAllRating(){
		Session session = sessionFactory.getCurrentSession();
		List<Rating> ratings = new ArrayList<>();
		ratings = session.createQuery("from Rating").list();
		
		return ratings;
	}
}
