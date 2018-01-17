package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Flag;
import com.revature.model.Genre;

@Repository
@Transactional
public class FlagDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Flag> getAllFlag(){
		Session session = sessionFactory.getCurrentSession();
		List<Flag> flags = new ArrayList<>();
		flags = session.createQuery("from Flag").list();
		
		return flags;
	}
}
