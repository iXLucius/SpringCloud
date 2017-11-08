package org.lucius.microservice.points.service;

import java.util.List;

import org.lucius.microservice.points.model.Order;

public interface OrderService {
	
	List<Order> queryOrdersByUserId();

}
