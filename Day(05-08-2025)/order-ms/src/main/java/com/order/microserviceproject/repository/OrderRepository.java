package com.order.microserviceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.order.microserviceproject.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
