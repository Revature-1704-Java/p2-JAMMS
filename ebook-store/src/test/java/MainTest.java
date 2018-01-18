import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.repository.BookDAO;

public class MainTest {

	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		CustomerTester ctest = new CustomerTester();
		ctest.printCustomers();
	}

	@Autowired
	public BookDAO bookDAO;

	public static void testingCustomerBooks() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("com.revature");
		MainTest mainTest = (MainTest) ac.getBean("application");
		ac.close();

		System.out.println(mainTest);

		// Customer c = mainApp.customerDAO.findCustomer(1);
		// System.out.println(c.toString());
		//
		// List<Book> books = mainApp.bookDAO.getAllBooks();
		// for (int i = 0; i < books.size(); i++) {
		// System.out.println(books.get(i).toString());
		// }
		//
		// Book b = mainApp.bookDAO.findBook(3);
		// System.out.println(b.toString());
	}

}
