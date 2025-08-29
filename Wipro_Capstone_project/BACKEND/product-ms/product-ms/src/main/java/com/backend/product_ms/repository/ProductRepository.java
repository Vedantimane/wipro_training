package com.backend.product_ms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.product_ms.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
    // Find products by exact name
    List<Product> findByProductName(String productName);

	
}
