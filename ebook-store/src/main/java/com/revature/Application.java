package com.revature;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.revature.model.Book;
import com.revature.model.Customer;
import com.revature.repository.BookDAO;
import com.revature.repository.CustomerDAO;

@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class })
@Repository
public class Application {

	public static void main(String[] args) {
		testingCustomerBooks();
//		SpringApplication.run(Application.class, args);
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

	@Autowired
	public BookDAO bdao;

	@Autowired
	public CustomerDAO cdao;

	public static void testingCustomerBooks() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("com.revature");
		Application mainApp = (Application) ac.getBean("application");
		ac.close();
		
		System.out.println(mainApp);
		System.out.println(mainApp.cdao);

//		Customer c = mainApp.cdao.findCustomer(1);
//		System.out.println(c.toString());
//
//		List<Book> books = mainApp.bdao.getAllBooks();
//		for (int i = 0; i < books.size(); i++) {
//			System.out.println(books.get(i).toString());
//		}
//
//		Book b = mainApp.bdao.findBook(3);
//		System.out.println(b.toString());
	}

}
