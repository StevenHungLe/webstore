/**
 * interface of the services that handle product-related operations
 */

package com.stevenlesoft.webstore.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.stevenlesoft.webstore.domain.Product;

public interface ProductService {
	List<Product> getAllProducts();
	Set<Product> getProductsByCategory(String productCategory);
	Set<Product> getProductsByFilter(Map<String,List<String>> filterParams);
	Set<Product> getProductsByFilter(String category, String brand, long priceFrom, long priceTo);
	Product getProductById(long productId);
	long addProduct(Product newProduct);
}
