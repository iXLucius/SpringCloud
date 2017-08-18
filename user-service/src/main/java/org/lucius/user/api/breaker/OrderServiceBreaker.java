package org.lucius.user.api.breaker;

import java.util.ArrayList;
import java.util.List;

import org.lucius.user.api.OrderServiceApi;
import org.lucius.user.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceBreaker implements OrderServiceApi{

	@Override
	public List<Order> getOrders() {
		return new ArrayList<>();
	}

}
