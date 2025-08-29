package com.backend.product_ms.service;

import java.util.List;

import com.backend.product_ms.entity.Product;

public interface ProductService {
	
	Product save(Product product);

    List<Product> findAll();

    Product findById(int productId);

    List<Product> findByProductName(String productName);

    void deleteById(int productId);

    Product updateProduct(int productId, Product product);  // new method

}
