/**
 * the controller to handle customer-related requests
 */
package com.stevenlesoft.webstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stevenlesoft.webstore.domain.Customer;
import com.stevenlesoft.webstore.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	// the autowired service bean to handle requested service
	@Autowired
	private CustomerService customerService;
	
	/**
	 * list all the customers in the database
	 * @param model
	 * @return name of the view to be rendered
	 */
	@RequestMapping
	public String listAllCustomers(Model model)
	{
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers";
	}
	
	/**
	 * list the details of a customer by id
	 * @param model
	 * @param customerId
	 * @return
	 */
	@RequestMapping("/customer")
	public String listCustomerById(Model model, @RequestParam String customerId)
	{
		model.addAttribute("customer", customerService.getCustomerById(Long.parseLong(customerId)));
		return "customer";
	}
	
	/**
	 * render the page that contains the add new customer form
	 * @param newCustomer
	 * @return
	 */
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String getAddCustomerForm(@ModelAttribute("newCustomer") Customer newCustomer )
	{
		return "addCustomer";
	}
	
	/**
	 * process an add new customer request
	 * @param newCustomer
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String processAddCustomerRequest(@Valid Customer newCustomer, BindingResult result )
	{
		long customerId = customerService.addCustomer(newCustomer);
		return "redirect:/customers/customer?customerId=" + customerId;
	}
}
