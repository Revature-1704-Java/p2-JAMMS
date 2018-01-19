package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping("/logins/{username}/{password}")
	public @ResponseBody Customer doLogin(@PathVariable("username") String username, @PathVariable("password") String password) {
		System.out.println("received");
		Customer c = cdao.findCustomer(1);
		System.out.println(c.getUsername());
		if (c.getPassword().equals(password)) {
			return c;
		} else {
			return null;
		}
	}

}