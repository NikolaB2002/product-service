package com.microservicespractice.ProductService.exception;

public class ProductInsufficientQuantityException extends RuntimeException{

    public ProductInsufficientQuantityException(String message) {
        super(message);
    }
}
