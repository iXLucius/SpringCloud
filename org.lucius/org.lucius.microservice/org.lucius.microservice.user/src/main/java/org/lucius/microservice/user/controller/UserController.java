package org.lucius.microservice.user.controller;


import java.util.List;

import org.lucius.commons.utils.exception.ServiceException;
import org.lucius.commons.utils.model.Result;
import org.lucius.microservice.user.api.OrderServiceApi;
import org.lucius.microservice.user.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "用户中心服务")
public class UserController {
	
	@Autowired
	private OrderServiceApi orderServiceApi;
	
	@GetMapping("/user/orders")
	@ApiOperation(value = "获取用户订单", notes = "获取用户订单")
	public List<Order> orders(@RequestParam @ApiParam(required = true,
            name = "id",
            defaultValue = "1428924542783",
            value = "订单ID") Long id){
		return orderServiceApi.getOrders();
	}
	
	@PostMapping("/user/order")
	@ApiOperation(value = "新增订单", notes = "新增订单")
	public Result<Boolean> addOrder(@RequestBody @ApiParam Order order){
		return new Result<Boolean>(true);
	}
	
	@GetMapping("/user/test")
	@ApiOperation(value = "测试ServiceException", notes = "测试ServiceException")
	public Result<Boolean> test(){
		throw new ServiceException("ORDER-01001010","测试错误");
	}
	
	@GetMapping("/user/null")
	@ApiOperation(value = "测试NullPointerException", notes = "测试NullPointerException")
	public String testThrowable(){
		Order o = null;
		//模拟空指针异常
		return o.toString();
	}

}
