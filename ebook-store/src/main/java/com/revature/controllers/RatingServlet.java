package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Genre;
import com.revature.model.Rating;
import com.revature.repository.RatingDAO;

@Controller
@RequestMapping
public class RatingServlet {

	@Autowired
	RatingDAO rdao;
	
	@RequestMapping("/ratings")
	public @ResponseBody List<Rating> getAllRatings(){
		return rdao.getAllRating();
	}
}
