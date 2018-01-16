package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Author;
import com.revature.model.Book;
import com.revature.repository.AuthorDAO;
import com.revature.repository.BookDAO;

@Controller
@RequestMapping
public class BookServlet{
	//private static final long serialVersionUID = 1L;
       
	@Autowired
	private BookDAO bdao;
	
	@Autowired
	private AuthorDAO adao;
    /**
     * @see HttpServlet#HttpServlet()
     */
	@RequestMapping("/hello")
	public String hello() {
		return "Hello from Spring Boot!";
	}
	
	@RequestMapping("/books")
	public @ResponseBody List<Book> getBookList() {
		
		return bdao.getAllBooks();
	}
	
	
	@RequestMapping("/authors")
	public @ResponseBody List<Author> getAuthorList() {
		
		return adao.getAllAuthors();
	}
	
	
	@RequestMapping("/book")
	public @ResponseBody Book getBook() {
		
		return bdao.findBook(1);
	}


	

}
