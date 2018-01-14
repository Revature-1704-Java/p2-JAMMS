package com.revature;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.revature.model.Customer;
import com.revature.repository.CustomerDAO;


@Component
public class Driver {

	@Autowired
	public CustomerDAO cdao;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = 
				new AnnotationConfigApplicationContext("com.revature");
		Driver driver = (Driver) ac.getBean("driver");
		Customer c = driver.cdao.findCustomer(1);
		System.out.println(c.toString());

	}
}
