package com.backend.order_ms.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.backend.order_ms.dto.OrderDTO;
import com.backend.order_ms.entity.Order;
import com.backend.order_ms.repository.OrderRepository;
import com.backend.order_ms.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate; // inject RestTemplate

    @Override
    public Order placeOrder(OrderDTO orderDTO) {
        Order order = Order.builder()
                .userId(orderDTO.getUserId())
                .productQuantityMap(orderDTO.getProductQuantityMap()) // <--- add this line
                .totalAmount(orderDTO.getTotalAmount())
                .orderStatus(orderDTO.getStatus() != null ? orderDTO.getStatus() : "PENDING")
                .orderDate(LocalDateTime.now())
                .build();

        return orderRepository.save(order);
    }

    @Override
    public Order confirmOrder(int orderId) {
        Order order = getOrderById(orderId);

        if (!order.getOrderStatus().equals("PENDING")) {
            throw new RuntimeException("Order cannot be confirmed. Current status: " + order.getOrderStatus());
        }

        // Reduce product quantities via API Gateway
        order.getProductQuantityMap().forEach((productId, qty) -> {
            String url = "http://localhost:8080/product/" + productId + "/reduce?quantity=" + qty;
            restTemplate.put(url, null); // call Product-MS through gateway
        });

        // Update order status
        order.setOrderStatus("PLACED");
        return orderRepository.save(order);
    }



    @Override
    public Order getOrderById(int orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public void cancelOrder(int orderId) {
        Order order = getOrderById(orderId);
        order.setOrderStatus("CANCELLED");
        orderRepository.save(order);
    }
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

}