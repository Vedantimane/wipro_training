package com.order.microserviceproject.service;

import java.util.List;
import com.order.microserviceproject.entity.Order;

public interface OrderService {

    Order save(Order order);

    List<Order> findAll();

    Order findById(int id);

    boolean deleteById(int id);

    boolean update(Order order);
}
