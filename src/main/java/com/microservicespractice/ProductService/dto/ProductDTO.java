package com.microservicespractice.ProductService.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private long productId;
    private String productName;
    private Long productQuantity;
    private Long productPrice;
}
