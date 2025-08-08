package com.order.microserviceproject.entity;

import java.util.List;

import com.order.microserviceproject.dto.Payment;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String orderNumber;
    private double orderValue;
    private String orderStatus;
    
  @Transient
    Payment payment;

}
