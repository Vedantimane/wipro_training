package com.order.microserviceproject.dto;

import lombok.Data;

@Data
public class Payment {
    private int paymentId;         // Change this
    private int orderId;
    private String paymentMode;
    private Double paymentAmount;
    private String paymentDescription;
    private boolean paymentStatus;
}