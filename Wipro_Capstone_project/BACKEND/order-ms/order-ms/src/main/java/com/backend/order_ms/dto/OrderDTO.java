package com.backend.order_ms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private int userId;
    private Map<Integer, Integer> productQuantityMap; // productId -> quantity
    private double totalAmount;
    private String status; // optional if you want to set PENDING by default
}
