package org.lucius.order.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.lucius.order.model.Order;
import org.lucius.order.service.OrderService;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
	
	public List<Order> queryOrdersByUserId(){
		List<Order> orders = new ArrayList<Order>();
		Order order = null;
		for(int i = 0; i < 10 ;i ++) {
			order = new Order();
			order.setId(RandomUtils.nextLong(1000000000L, 2000000000L));
			order.setOrderNo(RandomStringUtils.random(20, CHARS));
			order.setAmount(new BigDecimal(RandomUtils.nextDouble(2000.00D, 5000.00D)).setScale(2,BigDecimal.ROUND_HALF_UP));
			orders.add(order);
		}
		return orders;
	}

}
