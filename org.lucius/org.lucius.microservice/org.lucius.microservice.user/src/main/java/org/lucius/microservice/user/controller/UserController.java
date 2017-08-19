package org.lucius.microservice.user.controller;


import java.util.List;

import org.lucius.microservice.user.api.OrderServiceApi;
import org.lucius.microservice.user.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "用户中心服务")
public class UserController {
	
	@Autowired
	private OrderServiceApi orderServiceApi;
	
	@GetMapping("/user/orders")
	@ApiOperation(value = "获取用户订单", notes = "获取用户订单")
	public List<Order> orders(){
		return orderServiceApi.getOrders();
	}

}
