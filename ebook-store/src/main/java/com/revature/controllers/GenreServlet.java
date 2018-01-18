package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Genre;
import com.revature.repository.GenreDAO;

@Controller
@RequestMapping
public class GenreServlet {

	@Autowired
	GenreDAO gdao;

	@RequestMapping("/genres")
	public @ResponseBody List<Genre> getAllGenres() {
		return gdao.getAllGenre();
	}

}
