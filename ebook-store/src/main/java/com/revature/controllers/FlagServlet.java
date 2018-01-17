package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Flag;
import com.revature.model.Genre;
import com.revature.repository.FlagDAO;

@Controller
@RequestMapping
public class FlagServlet {

	@Autowired
	FlagDAO fdao;
	
	@RequestMapping("/flags")
	public @ResponseBody List<Flag> getAllGenres(){
		return fdao.getAllFlag();
	}
	
}
