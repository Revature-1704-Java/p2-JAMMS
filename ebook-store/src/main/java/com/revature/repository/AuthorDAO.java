package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Author;


@Repository
@Transactional
public class AuthorDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Author> getAllAuthors(){
		Session session = sessionFactory.getCurrentSession();
		List<Author> authors = new ArrayList<>();
		authors = session.createQuery("from Author").list();
		
		return authors;
	}
}
