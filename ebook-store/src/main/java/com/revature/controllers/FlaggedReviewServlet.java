package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.FlaggedReview;
import com.revature.model.Genre;
import com.revature.repository.FlaggedReviewDAO;

@Controller
@RequestMapping
public class FlaggedReviewServlet {
	@Autowired
	FlaggedReviewDAO frdao;
	
	@RequestMapping("/flagreviews")
	public @ResponseBody List<FlaggedReview> getAllGenres(){
		return frdao.getAllFlagReviews();
	}
}
