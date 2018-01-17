package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.PurchasedBook;
import com.revature.repository.PurchasedBookDAO;

@Controller
@RequestMapping
public class PurchasedBookServlet {
	
	@Autowired
	PurchasedBookDAO pbdao;
	
	@RequestMapping("/purchasedbooks")
	public @ResponseBody List<PurchasedBook> getAllPurchasedBooks(){
		return pbdao.getAllPurchasedBook();
	}
}
