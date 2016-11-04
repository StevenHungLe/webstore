package com.stevenlesoft.webstore.repository.impl;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.stevenlesoft.webstore.domain.Product;
import com.stevenlesoft.webstore.repository.AbstractHibernateRepository;
import com.stevenlesoft.webstore.repository.ProductRepository;

/**
 * an implementation of AbstractHibernateRepository
 * relies on methods defined in the super class to carry out its operations
 */
@SuppressWarnings("unchecked")
@Repository
public class HibernateProductRepository extends AbstractHibernateRepository<Long,Product> implements ProductRepository {
	
	public List<Product> getAllProducts() {
		beginTransaction();
		List<Product> productList = (List<Product>) createCriteria().list();
		endTransaction();
		return productList;
	}

	public Set<Product> getProductsByCategory(String productCategory) {
		beginTransaction();
		Set<Product> productSet = new HashSet<Product>((List<Product>)( productCategory == null? 
				createCriteria().list() 
				: createCriteria().add(Restrictions.eq("category", productCategory)).list()));
		endTransaction();
		return productSet;
	}

	public Set<Product> getProductsByBrand(String productBrand) {
		beginTransaction();
		Set<Product> productSet = new HashSet<Product>((List<Product>)( productBrand == null ? 
				createCriteria().list() 
				: createCriteria().add(Restrictions.eq("manufacturer", productBrand)).list()));
		endTransaction();
		return productSet;
	}

	public Set<Product> getProductsByPriceRange(long priceFrom, long priceTo) {
		if ( priceTo == 0)
			priceTo = Long.MAX_VALUE;
		beginTransaction();
		Set<Product> productSet = new HashSet<Product>((List<Product>)
				(createCriteria().add(Restrictions.ge("unitPrice", new BigDecimal(priceFrom)))
						.add(Restrictions.le("unitPrice", new BigDecimal(priceTo))).list() ));
		endTransaction();
		return productSet;
	}

	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product getProductById( long productId) {
		return getByKey(productId);
	}
	
	public long addProduct(Product newProduct)
	{
		return save(newProduct);
	}

	public void updateProduct(Product product)
	{
		update(product);
	}
}
