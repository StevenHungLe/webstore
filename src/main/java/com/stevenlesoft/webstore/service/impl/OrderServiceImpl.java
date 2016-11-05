/**
 * an implementation of OrderService
 */
package com.stevenlesoft.webstore.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stevenlesoft.webstore.domain.Customer;
import com.stevenlesoft.webstore.domain.Order;
import com.stevenlesoft.webstore.domain.Product;
import com.stevenlesoft.webstore.repository.CustomerRepository;
import com.stevenlesoft.webstore.repository.OrderRepository;
import com.stevenlesoft.webstore.repository.ProductRepository;
import com.stevenlesoft.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	// the autowired repositories to handle CRUD operations
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	/**
	 * process an order request
	 */
	public void processOrder(long productId, String username, int count) {
		
		// retrieve the product and customer involved in the order
		Product orderedProduct = productRepository.getProductById(productId);
		Customer orderingCustomer = customerRepository.getCustomerByUsername(username);
		
		// check order's validity
		if ( orderedProduct.getUnitsInStock() < count)
		{
			throw new IllegalArgumentException("Out of stock. Available unit in stock: "
					+ orderedProduct.getUnitsInStock());
		}
		
		Order newOrder = new Order(0, username, productId, count, new Date()); 
			
		// add the order to database
		orderRepository.addOrder(newOrder);
		
		// decrease the product's units in stock and update the change
		orderedProduct.setUnitsInStock(orderedProduct.getUnitsInStock() - count);
		productRepository.updateProduct(orderedProduct);
		
		// increase the customer's number of orders made and update the change
		orderingCustomer.setNumberOfOrdersMade(orderingCustomer.getNumberOfOrdersMade() + 1);
		customerRepository.updateCustomer(orderingCustomer);
	}

}
