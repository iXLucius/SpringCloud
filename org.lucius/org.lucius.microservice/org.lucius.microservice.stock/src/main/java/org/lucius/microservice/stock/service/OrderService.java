package org.lucius.microservice.stock.service;

import java.util.List;

import org.lucius.microservice.stock.model.Order;

public interface OrderService {
	
	List<Order> queryOrdersByUserId();

}
