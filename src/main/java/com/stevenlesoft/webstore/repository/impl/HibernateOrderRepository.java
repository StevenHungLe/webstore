package com.stevenlesoft.webstore.repository.impl;

import org.springframework.stereotype.Repository;

import com.stevenlesoft.webstore.domain.Order;
import com.stevenlesoft.webstore.repository.AbstractHibernateRepository;
import com.stevenlesoft.webstore.repository.OrderRepository;

/**
 * an implementation of AbstractHibernateRepository
 * relies on methods defined in the super class to carry out its operations
 */
@Repository
public class HibernateOrderRepository extends AbstractHibernateRepository<Long,Order> implements OrderRepository {
	
	public long addOrder(Order order) {
		return save(order);
	}
}
