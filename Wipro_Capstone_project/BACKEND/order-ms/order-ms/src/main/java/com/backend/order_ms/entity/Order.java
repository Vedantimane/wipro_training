package com.backend.order_ms.entity;

import java.time.LocalDateTime;
import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    
    private int userId;
    
    @ElementCollection
    private Map<Integer, Integer> productQuantityMap; // productId -> quantity
    
    private double totalAmount;
    
    private String orderStatus;
    
    private LocalDateTime orderDate;
}
