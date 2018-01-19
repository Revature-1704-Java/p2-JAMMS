package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Author;
import com.revature.model.Book;
import com.revature.repository.AuthorDAO;
import com.revature.repository.BookDAO;
import com.revature.repository.PurchasedBookDAO;

@Controller
@RequestMapping
@CrossOrigin()
public class BookServlet {
	// private static final long serialVersionUID = 1L;

	@Autowired
	private BookDAO bdao;

	@Autowired
	private AuthorDAO adao;
	
	@Autowired
	private PurchasedBookDAO pdao;

	@RequestMapping("/books")
	public @ResponseBody List<Book> getBookList() {

		return bdao.getAllBooks();
	}

	@RequestMapping("/authors")
	public @ResponseBody List<Author> getAuthorList() {

		return adao.getAllAuthors();
	}

	@RequestMapping("/books/{id}")
	public @ResponseBody Book getBook(@PathVariable("id") Integer id) {

		return bdao.findBook(id);

	}
	
	@RequestMapping("/purchase/{id}")
	public @ResponseBody String purchaseBook(@PathVariable("id") Integer id) {
		System.out.println("Purchase Book");
		Book book = bdao.findBook(id);
		System.out.println(book.toString());
		pdao.addBookToPurchases(book);
		System.out.println("Book Purchased");
		return "Book Purchased";
	}
}
