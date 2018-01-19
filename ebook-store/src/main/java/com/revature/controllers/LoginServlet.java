package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Customer;
import com.revature.repository.CustomerDAO;

@Controller
@RequestMapping
@CrossOrigin()
public class LoginServlet {
	// private static final long serialVersionUID = 1L;

	@Autowired
	private CustomerDAO cdao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@RequestMapping("/customers")
	public @ResponseBody List<Customer> getAllCustomers() {
		return cdao.getAllCustomer();

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Customer doLogin(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		System.out.println(username);
		System.out.println(password);
		return cdao.findCustomer(username, password);
//		return new Customer();
	}

}