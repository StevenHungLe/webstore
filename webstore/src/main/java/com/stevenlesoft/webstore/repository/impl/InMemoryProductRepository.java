/**
 * a simple non-persistence repository created for testing purposes
 * creates and maintains a volatile list of products in memory 
 */

package com.stevenlesoft.webstore.repository.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;

import com.stevenlesoft.webstore.domain.Product;
import com.stevenlesoft.webstore.repository.ProductRepository;


@Repository
public class InMemoryProductRepository implements ProductRepository{

	private List<Product> listOfProducts = new ArrayList<Product>();
	
	/**
	 * creates some products for testing purposes 
	 */
	public InMemoryProductRepository() {
		Product laptop_dell = new Product("dellins14","Dell Inspiron", new BigDecimal(700));
		laptop_dell.setDescription("Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors");
		laptop_dell.setCategory("Laptop");
		laptop_dell.setManufacturer("Dell");
		laptop_dell.setUnitsInStock(1000);
		
		Product tablet_Nexus = new Product("googlenex7","Nexus 7", new BigDecimal(300));
		tablet_Nexus.setDescription("Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon™ S4 Pro processor");
		tablet_Nexus.setCategory("Tablet");
		tablet_Nexus.setManufacturer("Google");
		tablet_Nexus.setUnitsInStock(1000);
		
		Product iphone = new Product("appleip7","Apple Iphone 7", new BigDecimal(800));
		iphone.setDescription("This iphone is so awesome it doesn't need a headphone jack because headphone jack is for noobs");
		iphone.setCategory("Smart Phone");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);
		
		listOfProducts.add(laptop_dell);
		listOfProducts.add(tablet_Nexus);
		listOfProducts.add(iphone);
	}
	
	/**
	 * retrieve all products available
	 */
	public List<Product> getAllProducts() {
		return listOfProducts;
	}
	
	
	/**
	 * retrieve a set of products filtered by category
	 */
	public Set<Product> getProductsByCategory(String productCategory)
	{
		Set<Product> productsByCategory = new HashSet<Product>();
		
		for(Product product: listOfProducts)
		{
			if (product != null && product.getCategory() != null &&
					product.getCategory().equalsIgnoreCase(productCategory))
				productsByCategory.add(product);
		}
		
		return productsByCategory;
	}
	
	
	/**
	 * retrieve a set of products filtered by brand
	 */
	public Set<Product> getProductsByBrand(String productBrand)
	{
		Set<Product> productsByBrand = new HashSet<Product>();
		
		for(Product product: listOfProducts)
		{
			if (product != null && product.getManufacturer() != null &&
					product.getManufacturer().equalsIgnoreCase(productBrand))
				productsByBrand.add(product);
		}
		
		return productsByBrand;
	}
	
	
	/**
	 * retrieve a set of products filtered by price range
	 */
	public Set<Product> getProductsByPriceRange(long priceFrom, long priceTo)
	{
		Set<Product> productsByPriceRange = new HashSet<Product>();
		
		for(Product product: listOfProducts)
		{
			if(product != null && product.getUnitPrice()!= null &&
					product.getUnitPrice().compareTo(new BigDecimal(priceFrom)) >= 0
					&& product.getUnitPrice().compareTo(new BigDecimal(priceTo)) <= 0)
				productsByPriceRange.add(product);
		}
		
		return productsByPriceRange;
	}
	
	/**
	 * retrieve a set of product filtered by multiple brands and categories
	 */
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams)
	{
		Set<Product> productsByBrand = new HashSet<Product>();
		Set<Product> productsByCategory = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();
		
		if(criterias.contains("brand")) {
			for(String brandName: filterParams.get("brand")) {
				for(Product product: listOfProducts) {
					if(brandName.equalsIgnoreCase(product.getManufacturer())){
						productsByBrand.add(product);
					}
				}
			}
		}
		
		if(criterias.contains("category")) {
			for(String category: filterParams.get("category")) {
				productsByCategory.addAll(this.getProductsByCategory(category));
			}
		}
		
		if(productsByCategory.isEmpty())
			return productsByBrand;
		else if(productsByBrand.isEmpty())
			return productsByCategory;
		else
		{
			productsByCategory.retainAll(productsByBrand);
			return productsByCategory;
		}
			
	}
	
	
	/**
	 * retrieve the product specified by the product id
	 */
	public Product getProductById(String productId) {
		Product requestedProduct = null;
		
		for ( Product product: listOfProducts)
		{
			if (product != null && product.getProductId()!= null
					&& product.getProductId().equals(productId))
				requestedProduct = product;
		}
		
		if ( requestedProduct == null)
			throw new IllegalArgumentException("No product found with the product id: "+productId);
		
		return requestedProduct;
	}

}
