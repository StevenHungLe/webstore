/**
 * interface of the services that handle order-related operations
 */

package com.stevenlesoft.webstore.service;

public interface OrderService {
	void processOrder(String productId, int count);
}
