package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Cart;
import com.revature.repository.CartDAO;

@Controller
@RequestMapping
public class CartServlet {
	
	@Autowired
	CartDAO ctdao;
	
	//not a useful function, but used for testing
	@RequestMapping("/carts")
	public @ResponseBody List<Cart> getAllCartItem(){
		return ctdao.getAllCartItems();
	}
}
