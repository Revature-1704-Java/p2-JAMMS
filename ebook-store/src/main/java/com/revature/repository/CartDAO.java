package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Cart;
import com.revature.model.Genre;

@Repository
@Transactional
public class CartDAO {
	//functions needed: insertBook, getAll, deleteBook
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Cart> getAllCartItems(){
		Session session = sessionFactory.getCurrentSession();
		List<Cart> cartitems = new ArrayList<>();
		cartitems = session.createQuery("from Cart").list();
		
		return cartitems;
	}
	

}
