package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Genre;

@Repository
@Transactional
public class GenreDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	public List<Genre> getAllGenre(){
		Session session = sessionFactory.getCurrentSession();
		List<Genre> genre = new ArrayList<>();
		genre= session.createQuery("from Genre").list();
		
		return genre;
	}
}
