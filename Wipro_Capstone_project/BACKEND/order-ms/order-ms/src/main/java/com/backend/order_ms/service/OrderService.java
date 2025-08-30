package com.backend.order_ms.service;

import java.util.List;

import com.backend.order_ms.dto.OrderDTO;
import com.backend.order_ms.entity.Order;

public interface OrderService {
	 Order placeOrder(OrderDTO orderDTO);

	    Order getOrderById(int orderId);

	    List<Order> getOrdersByUserId(int userId);

	    void cancelOrder(int orderId);

		Order confirmOrder(int orderId);
		
		List<Order> getAllOrders();


}
