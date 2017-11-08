package org.lucius.microservice.coupon.service;

import java.util.List;

import org.lucius.microservice.coupon.model.Order;

public interface OrderService {
	
	List<Order> queryOrdersByUserId();

}
