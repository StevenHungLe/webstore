/**
 * the controller to handle default/root requests
 */
package com.stevenlesoft.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	/**
	 * set greeting and tagline for the welcome page
	 * @param model
	 * @return name of the view to be rendered
	 */
	@RequestMapping("/")
	public String welcome(Model model)
	{
		model.addAttribute("greeting", "Welcome to my webstore!");
		model.addAttribute("tagline","the greatest webstore in my fantasy");
		
		return "welcome";
	}

}
