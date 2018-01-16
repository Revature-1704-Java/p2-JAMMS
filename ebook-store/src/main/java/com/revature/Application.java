package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.revature.model.Book;
import com.revature.model.Customer;
import com.revature.repository.BookDAO;
import com.revature.repository.CustomerDAO;


@SpringBootApplication
public class Application {
	
	
	//@Autowired
	//public BookDAO bdao;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*
	 * @Autowired
	public CustomerDAO cdao;
	
	
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = 
				new AnnotationConfigApplicationContext("com.revature");
		Driver driver = (Driver) ac.getBean("driver");
		
		Customer c = driver.cdao.findCustomer(1);
		System.out.println(c.toString());
		
		
		Book b = driver.bdao.findBook(3);
		System.out.println(b.toString());
	 * 
	 * 
	}
	 * 
	 * 
	 */
	
		//List<Book> books = driver.bdao.getAllBooks();
		//for(int i = 0; i < books.size(); i++) {
		//	System.out.println(books.get(i).toString());
		//}
		

}
