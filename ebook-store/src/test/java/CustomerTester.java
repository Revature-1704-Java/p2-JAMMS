import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.Customer;
import com.revature.repository.CustomerDAO;

public class CustomerTester {

	@Autowired
	public CustomerDAO customerDAO;
	
	public void printCustomers() {
		System.out.println(customerDAO);

		Customer c = customerDAO.findCustomer(1);
		System.out.println(c.toString());
	}
}
