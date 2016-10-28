/**
 * a simple non-persistence repository created for testing purposes
 * creates and maintains a volatile list of customers in memory 
 */
package com.stevenlesoft.webstore.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.stevenlesoft.webstore.domain.Customer;
import com.stevenlesoft.webstore.repository.CustomerRepository;



@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
	private List<Customer> listOfCustomers;
	
	/**
	 * creates some customers for testing purposes 
	 */
	public InMemoryCustomerRepository()
	{
		listOfCustomers = new ArrayList<Customer>();
		
		Customer customer1 = new Customer("tonystark@hotmail.com","Tony Stark","Stark Building, 1000 Stark St, Massachusetts");
		Customer customer2 = new Customer("captainamerica@gmail.com","Chris Evan","Avengers Building, 1 America St, Washington D.C.");
		Customer customer3 = new Customer("trumpforpresident2016@trump.com","Donald Trump","Trump Tower, 999 Mexican Wall St, New York");
		
		listOfCustomers.add(customer1);
		listOfCustomers.add(customer2);
		listOfCustomers.add(customer3);
	}
	
	public List<Customer> getAllCustomers() {
		return listOfCustomers;
	}

}
