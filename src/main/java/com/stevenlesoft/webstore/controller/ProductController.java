/**
 * controller for product-related requests
 */

package com.stevenlesoft.webstore.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stevenlesoft.webstore.domain.Product;
import com.stevenlesoft.webstore.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	// the autowired service bean to handle requested service
	@Autowired
	private ProductService productService;
	
	
	/**
	 * initialize the WebDataBinder bean and disallow entries for some fields
	 * @param binder
	 */
	@InitBinder
	public void initializeBinder(WebDataBinder binder)
	{
		binder.setDisallowedFields("discontinued","unitsInOrder");
	}
	
	
	/**
	 * list all products in stock
	 * @param model
	 * @return name of the view to be rendered
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String listAllProducts(Model model)
	{
		model.addAttribute("tagline","All the products we carry");
		model.addAttribute("products",productService.getAllProducts());
		return "products";
	}
	
	
	/**
	 * list products that satisfy all filter criteria received in the filter form
	 * @param model
	 * @param category
	 * @param brand
	 * @param priceFrom
	 * @param priceTo
	 * @return name of the view to be rendered
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String listProductsByFilter(Model model, 
			@RequestParam(required=false) String category,
			@RequestParam(required=false) String brand, 
			@RequestParam(required=false) long priceFrom, 
			@RequestParam(required=false) long priceTo)
	{
		model.addAttribute("tagline","Filtered products");
		model.addAttribute("products", productService.getProductsByFilter(category,brand,priceFrom,priceTo));
		return "products";
	}
	
	
	/**
	 * list products by category
	 * requestURL must be in the form "webstore/products/{category}
	 * @param model
	 * @param category
	 * @return name of the view to be rendered
	 */
	@RequestMapping("/{category}")
	public String listProductsByCategory(Model model, @PathVariable String category)
	{
		model.addAttribute("tagline","in category "+ category);
		model.addAttribute("products", productService.getProductsByCategory(category));
		return "products";
	}
	
	
	/**
	 * list products by criteria specified by matrix variables
	 * requestURL must be in the form webstore/products/filter/ByCriteria;brand=brand1,brand2;category=cat1,cat2
	 * @param model
	 * @param filterParams
	 * @return name of the view to be rendered
	 */
	@RequestMapping("/filter/{ByCriteria}")
	public String listProductsByCriteria(Model model, 
			@MatrixVariable(pathVar="ByCriteria") Map<String,List<String>> filterParams)
	{
		model.addAttribute("tagline","Filtered products");
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		return "products";
	}
	
	
	/**
	 * list product by its id
	 * @param model
	 * @param productId
	 * @param orderMade specifying whether an order is made, set by the logic of product.jsp
	 * @return name of the view to be rendered
	 */
	@RequestMapping("/product")
	public String listProductById(Model model, @RequestParam("id") long productId, 
			@RequestParam(defaultValue="false") String orderMade)
	{
		model.addAttribute("orderMade", orderMade);
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}
	
	/**
	 * render the page that contains the add product form
	 * @param newProduct the data binding object
	 * @return name of the view to be rendered
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddProductForm(@ModelAttribute("newProduct") Product newProduct)
	{
		return "addProduct";
	}
	
	/**
	 * process an add new product post request
	 * @param newProduct
	 * @param result
	 * @return name of the view to be rendered
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddProductRequest(@Valid Product newProduct, BindingResult result)
	{	
		long productId = productService.addProduct(newProduct);
		return "redirect:/products/product?id="+productId;
	}

}
