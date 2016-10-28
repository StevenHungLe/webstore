/**
 * the controller to handle order requests
 */
package com.stevenlesoft.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stevenlesoft.webstore.service.OrderService;

@Controller
public class OrderController {
	
	// the autowired service bean to handle requested services
	@Autowired
	private OrderService orderService;
	
	/**
	 * handle the processing when an order is made
	 * @param productId
	 * @param quantity
	 * @return name of the view to be rendered
	 */
	@RequestMapping("/order/{productId}/{quantity}")
	public String processOrder(@PathVariable String productId, @PathVariable int quantity)
	{
		orderService.processOrder(productId, quantity);
		
		return "redirect:/products/product?id="+productId+"&orderMade=true";
	}
}
