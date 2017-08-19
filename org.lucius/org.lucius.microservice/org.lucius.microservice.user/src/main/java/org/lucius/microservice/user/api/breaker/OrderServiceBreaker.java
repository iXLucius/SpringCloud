package org.lucius.microservice.user.api.breaker;

import java.util.ArrayList;
import java.util.List;

import org.lucius.microservice.user.api.OrderServiceApi;
import org.lucius.microservice.user.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceBreaker implements OrderServiceApi{

	@Override
	public List<Order> getOrders() {
		return new ArrayList<>();
	}

}
