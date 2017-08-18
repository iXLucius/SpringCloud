package org.lucius.user.api;


import java.util.List;

import org.lucius.user.api.breaker.OrderServiceBreaker;
import org.lucius.user.model.Order;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "org-lucius-microservice-order-service",fallback = OrderServiceBreaker.class)
public interface OrderServiceApi {
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
    List<Order> getOrders();

}