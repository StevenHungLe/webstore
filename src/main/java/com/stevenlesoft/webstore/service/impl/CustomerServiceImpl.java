/**
 * an implementation of CustomerService 
 */
package com.stevenlesoft.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.stevenlesoft.webstore.domain.Customer;
import com.stevenlesoft.webstore.repository.CustomerRepository;
import com.stevenlesoft.webstore.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	// the autowired repository to handle CRUD operations
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}

	public Customer getCustomerByUsername(String userName)
	{
		return customerRepository.getCustomerByUsername(userName);
	}
	
	public Customer getCustomerById(long id) {
		return customerRepository.getCustomerById(id);
	}
	
	/**
	 * add a new customer to database
	 */
	public long addCustomer(Customer newCustomer)
	{
		// hash customer password before persisting in database
		String hashedPassword = BCrypt.hashpw(newCustomer.getCustomerPassword(), BCrypt.gensalt());
		newCustomer.setCustomerPassword( hashedPassword );
		long customerId = customerRepository.addCustomer(newCustomer);
		return customerId;
	}

	
	
	
}
