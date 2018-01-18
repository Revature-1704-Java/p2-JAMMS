package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Review;
import com.revature.repository.ReviewDAO;

@Controller
@RequestMapping
public class ReviewServlet {

	@Autowired
	ReviewDAO revdao;

	@RequestMapping("/reviews")
	public @ResponseBody List<Review> getAllReviews() {
		return revdao.getAllReviews();
	}
}
