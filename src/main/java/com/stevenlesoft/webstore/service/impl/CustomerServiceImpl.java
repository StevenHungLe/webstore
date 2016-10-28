/**
 * an implementation of CustomerService 
 */
package com.stevenlesoft.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}
