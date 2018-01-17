package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.model.Author;
import com.revature.model.Book;


@Repository
@Transactional
public class AuthorDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Author> getAllAuthors(){
		Session session = sessionFactory.getCurrentSession();
		List<Author> authors = new ArrayList<>();
		authors = session.createQuery("from Author").list();
		
		return authors;
	}
}
