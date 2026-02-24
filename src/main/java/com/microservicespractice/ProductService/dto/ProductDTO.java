package com.microservicespractice.ProductService.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long productId;
    private String productName;
    private Long productQuantity;
    private Long productPrice;
}
