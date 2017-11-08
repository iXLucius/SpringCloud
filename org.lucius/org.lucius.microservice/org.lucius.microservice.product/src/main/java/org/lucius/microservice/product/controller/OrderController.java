package org.lucius.microservice.product.controller;

import java.util.List;

import org.lucius.microservice.product.model.Order;
import org.lucius.microservice.product.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Value("${lucius.email}")
	private String email;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/orders")
	public List<Order> index() {
		return orderService.queryOrdersByUserId();
	}
	
	@GetMapping("/email")
	public String email() {
		return email;
	}
	
}
