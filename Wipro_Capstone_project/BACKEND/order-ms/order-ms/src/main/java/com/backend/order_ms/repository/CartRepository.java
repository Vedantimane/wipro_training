package com.backend.order_ms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.order_ms.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	    Cart findByUserId(int userId);
}

