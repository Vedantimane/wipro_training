package com.backend.order_ms.dto;

import java.util.Map;

import lombok.Data;

@Data
public class CartDTO {
    private int userId;
    private Map<Integer, Integer> productQuantityMap; // productId -> quantity
    private double totalAmount;
}