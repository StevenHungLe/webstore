/**
 * an implementation of OrderService
 */
package com.stevenlesoft.webstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stevenlesoft.webstore.domain.Product;
import com.stevenlesoft.webstore.repository.ProductRepository;
import com.stevenlesoft.webstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	// the autowired repository to handle CRUD operations
	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * process an order by deducting units in stock by purchased quantity
	 */
	public void processOrder(String productId, int count) {
		Product orderedProduct = productRepository.getProductById(productId);
		
		if ( orderedProduct.getUnitsInStock() < count)
		{
			throw new IllegalArgumentException("Out of stock. Available unit in stock: "
					+ orderedProduct.getUnitsInStock());
		}
			
		orderedProduct.setUnitsInStock(orderedProduct.getUnitsInStock() - count);
	}

}
