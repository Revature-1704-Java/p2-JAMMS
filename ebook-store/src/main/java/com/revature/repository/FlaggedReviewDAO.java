package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.FlaggedReview;

@Repository
@Transactional
public class FlaggedReviewDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<FlaggedReview> getAllFlagReviews(){
		Session session = sessionFactory.getCurrentSession();
		List<FlaggedReview> flaggedreviews = new ArrayList<>();
		flaggedreviews = session.createQuery("from FlaggedReview").list();
		
		return flaggedreviews;
	}
}
