package com.stevenlesoft.webstore.repository;

import com.stevenlesoft.webstore.domain.Order;

public interface OrderRepository {
	long addOrder(Order order);
}
