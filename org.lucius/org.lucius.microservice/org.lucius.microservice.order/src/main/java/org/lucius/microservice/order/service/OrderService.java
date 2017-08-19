package org.lucius.microservice.order.service;

import java.util.List;

import org.lucius.microservice.order.model.Order;

public interface OrderService {
	
	List<Order> queryOrdersByUserId();

}
