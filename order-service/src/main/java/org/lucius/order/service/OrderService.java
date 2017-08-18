package org.lucius.order.service;

import java.util.List;

import org.lucius.order.model.Order;

public interface OrderService {
	
	List<Order> queryOrdersByUserId();

}
