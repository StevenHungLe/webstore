/**
 * interface of the repository that handle CRUD operations on customers
 */
package com.stevenlesoft.webstore.repository;

import java.util.List;

import com.stevenlesoft.webstore.domain.Customer;

public interface CustomerRepository {
	List<Customer> getAllCustomers();
	Customer getCustomerByUsername(String userName);
	Customer getCustomerById(long id);
	long addCustomer(Customer newCustomer);
}
