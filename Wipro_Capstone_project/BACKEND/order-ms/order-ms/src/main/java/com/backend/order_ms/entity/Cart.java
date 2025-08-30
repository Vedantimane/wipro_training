package com.backend.order_ms.entity;

import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId; // changed from orderId
    
    private int userId;
    
    @ElementCollection
    private Map<Integer, Integer> productQuantityMap; // productId -> quantity
    
    private double totalAmount;
}
