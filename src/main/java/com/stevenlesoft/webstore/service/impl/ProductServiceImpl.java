/**
 * an implementation of ProductService
 */
package com.stevenlesoft.webstore.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stevenlesoft.webstore.domain.Product;
import com.stevenlesoft.webstore.repository.ProductRepository;
import com.stevenlesoft.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	// the autowired repository to handle CRUD operations
	@Autowired
	private ProductRepository productRepository;

	/**
	 * retrieve all products in the database
	 */
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}
	
	/**
	 * retrieve a set of products filtered by category
	 */
	public Set<Product> getProductsByCategory(String productCategory)
	{
		return productRepository.getProductsByCategory(productCategory);
	}

	/**
	 * retrieve a set of products filtered by multiple brands and categories
	 */
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		return productRepository.getProductsByFilter(filterParams);
	}

	/**
	 * overloaded method of getProductsByFilter
	 * retrieve a set of products filtered by brand, category, and price range
	 */
	public Set<Product> getProductsByFilter(String category, String brand, long priceFrom, long priceTo) {
		
		Set<Product> productsByCategory = productRepository.getProductsByCategory(category);
		productsByCategory.retainAll(productRepository.getProductsByBrand(brand));
		productsByCategory.retainAll(productRepository.getProductsByPriceRange(priceFrom, priceTo));
		return productsByCategory;
	}

	/**
	 * retrieve the product specified by the product id
	 */
	public Product getProductById(long productId) {
		return productRepository.getProductById(productId);
	}
	
	/**
	 * add a new product to database
	 */
	public long addProduct(Product newProduct)
	{
		return productRepository.addProduct(newProduct);
	}
	
}
