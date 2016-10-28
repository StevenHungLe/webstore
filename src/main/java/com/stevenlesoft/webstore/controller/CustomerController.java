/**
 * the controller to handle customer-related requests
 */
package com.stevenlesoft.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stevenlesoft.webstore.service.CustomerService;

@Controller
public class CustomerController {

	// the autowired service bean to handle requested service
	@Autowired
	private CustomerService customerService;
	
	/**
	 * list all the customers in the database
	 * @param model
	 * @return name of the view to be rendered
	 */
	@RequestMapping("/customers")
	public String listAllCustomers(Model model)
	{
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers";
	}
}
