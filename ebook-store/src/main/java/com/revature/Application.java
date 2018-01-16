package com.revature;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.revature.model.Book;
import com.revature.model.Customer;
import com.revature.repository.BookDAO;
import com.revature.repository.CustomerDAO;


@SpringBootApplication(exclude={HibernateJpaAutoConfiguration.class})
public class Application {
	
	
	//@Autowired
	//public BookDAO bdao;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
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
