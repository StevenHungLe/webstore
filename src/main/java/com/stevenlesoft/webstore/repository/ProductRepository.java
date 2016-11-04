/**
 * interface of the repository that handle CRUD operations on products
 */
package com.stevenlesoft.webstore.repository;

import com.stevenlesoft.webstore.domain.Product;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductRepository {
	List<Product> getAllProducts();
	Set<Product> getProductsByCategory(String productCategory);
	Set<Product> getProductsByBrand(String productBrand);
	Set<Product> getProductsByPriceRange(long priceFrom, long priceTo);
	Set<Product> getProductsByFilter(Map<String,List<String>> filterParams);
	Product getProductById(long productId);
	long addProduct(Product newProduct);
	void updateProduct(Product product);
}
