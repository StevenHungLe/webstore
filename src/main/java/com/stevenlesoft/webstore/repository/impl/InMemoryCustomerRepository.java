package com.stevenlesoft.webstore.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.stevenlesoft.webstore.domain.Customer;
import com.stevenlesoft.webstore.repository.CustomerRepository;

/**
 * a simple non-persistence repository created for testing purposes
 * creates and maintains a volatile list of customers in memory 
 */
// To use: uncomment this annotation and comment out the other implementation's annotation
//@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
	private List<Customer> listOfCustomers;
	
	/**
	 * creates some customers for testing purposes 
	 */
	public InMemoryCustomerRepository()
	{
		listOfCustomers = new ArrayList<Customer>();
		Customer customer1 = new Customer(1,"tonystark@hotmail.com","default-password","Tony Stark","Stark Building, 1000 Stark St, Massachusetts",0);
		Customer customer2 = new Customer(2,"captainamerica@gmail.com","default-password","Chris Evan","Avengers Building, 1 America St, Washington D.C.",0);
		Customer customer3 = new Customer(3,"trumpforpresident2016@trump.com","default-password","Donald Trump","Trump Tower, 999 Mexican Wall St, New York",0);
		
		listOfCustomers.add(customer1);
		listOfCustomers.add(customer2);
		listOfCustomers.add(customer3);
	}
	
	public List<Customer> getAllCustomers() {
		return listOfCustomers;
	}

	public Customer getCustomerByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	public long addCustomer(Customer newCustomer) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Customer getCustomerById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
