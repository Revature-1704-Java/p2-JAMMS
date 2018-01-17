package com.revature.controllers;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Customer;
import com.revature.repository.CustomerDAO;

@Controller
@RequestMapping
public class LoginServlet{
	//private static final long serialVersionUID = 1L;
       
	@Autowired
	private CustomerDAO cdao;
    /**
     * @see HttpServlet#HttpServlet()
     */


	@RequestMapping("/customers")
	public @ResponseBody List<Customer> getAllCustomers(){
		return cdao.getAllCustomer();
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String doLogin(String username, String password) {
		
		Customer c = cdao.findCustomer(username);
		
		if(c.getPassword().equals(password)) {
			return "redirect: index";
		}
		else {
			return "redirect: login";
		}
	}


	

}