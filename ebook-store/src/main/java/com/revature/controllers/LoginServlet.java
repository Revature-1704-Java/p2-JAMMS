package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Customer;
import com.revature.repository.CustomerDAO;

@Controller
@RequestMapping
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
	public @ResponseBody Customer doLogin(@PathVariable("username") String username,
			@PathVariable("username") String password) {

		return cdao.findCustomer(username, password);
	}

}