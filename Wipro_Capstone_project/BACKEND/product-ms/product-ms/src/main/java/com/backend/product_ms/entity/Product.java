package com.backend.product_ms.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    
    @NotBlank
    private String productName;
    
    
    @NotBlank
    private String productDesc;
    
    @NotBlank
    private String productCat;
    
    @NotBlank
    private String make;
    
    @NotNull
    private Integer productAvailableQty; // use Integer instead of int for validation
    
    @NotNull
    private Double productPrice;
    
    @NotBlank
    private String productImgUrl;
    
    private LocalDate dateOfManufacture;
}
