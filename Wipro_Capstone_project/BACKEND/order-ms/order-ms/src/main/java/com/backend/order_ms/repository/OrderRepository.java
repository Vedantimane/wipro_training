package com.backend.order_ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.order_ms.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	 List<Order> findByUserId(int userId);
}
