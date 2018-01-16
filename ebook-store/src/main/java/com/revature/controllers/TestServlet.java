package com.revature.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Servlet implementation class TestServlet
 */
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Book;
import com.revature.model.Customer;
import com.revature.repository.BookDAO;

@RestController
public class TestServlet{
	//private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@RequestMapping("/hello")
	public String hello() {
		return "Hello from Spring Boot!";
	}
	
	@RequestMapping("/books")
	public @ResponseBody Book getBookList() {
		BookDAO bdao = new BookDAO();
		Book b = bdao.findBook(1);
		//Book b = new Book();
		//b.setId(1);
		//b.setListPrice(4.99);
		//b.setTitle("Fifty Shades of Grey");
		return b;
	}
	


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
