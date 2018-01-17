package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Discount;
import com.revature.repository.DiscountDAO;

@Controller
@RequestMapping
public class DiscountServlet {

	@Autowired
	DiscountDAO ddao;
	
	@RequestMapping("/discounts")
	public @ResponseBody List<Discount> getDiscountList(){
		return ddao.getAllDiscounts();
	}
}
