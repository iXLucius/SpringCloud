package org.lucius.user.controller;


import java.util.List;

import org.lucius.user.api.OrderServiceApi;
import org.lucius.user.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private OrderServiceApi orderServiceApi;
	
	@GetMapping("/user/orders")
	public List<Order> orders(){
		return orderServiceApi.getOrders();
	}

}
