package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Book_Genre;
import com.revature.repository.Book_GenreDAO;

@Controller
@RequestMapping
public class Book_GenreServlet {

	@Autowired
	Book_GenreDAO bgdao;

	@RequestMapping("/bookgenres")
	public @ResponseBody List<Book_Genre> getAllGenres() {
		return bgdao.getAllBookGenre();
	}

}
