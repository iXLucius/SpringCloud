package org.lucius.microservice.product.service;

import java.util.List;

import org.lucius.microservice.product.model.Order;

public interface OrderService {
	
	List<Order> queryOrdersByUserId();

}
