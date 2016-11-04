/**
 * interface of the services that handle customer-related operations
 */

package com.stevenlesoft.webstore.service;

import java.util.List;

import com.stevenlesoft.webstore.domain.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	Customer getCustomerByUsername(String userName);
	Customer getCustomerById(long id);
	long addCustomer(Customer newCustomer);
}
