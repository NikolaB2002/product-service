package com.microservicespractice.ProductService.exception;

import lombok.Data;

@Data
public class ProductInsufficientQuantityException extends RuntimeException{
    private String errorCode;

    public ProductInsufficientQuantityException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
