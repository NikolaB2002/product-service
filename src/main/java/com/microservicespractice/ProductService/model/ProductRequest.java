package com.microservicespractice.ProductService.model;

import lombok.Data;

@Data
public class ProductRequest {
    private String productName;
    private Long productPrice;
    private Long productQuantity;
}
