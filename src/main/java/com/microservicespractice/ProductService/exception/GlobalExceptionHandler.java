package com.microservicespractice.ProductService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApplicationError> handleProductNotFoundException(ProductNotFoundException ex) {
        ApplicationError error = new ApplicationError(
                LocalDateTime.now(),
                ex.getMessage(),
                "PRODUCT_NOT_FOUND"
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductInsufficientQuantityException.class)
    public ResponseEntity<ApplicationError> handleProductInsufficientQuantityException(ProductInsufficientQuantityException ex) {
        ApplicationError error = new ApplicationError(
                LocalDateTime.now(),
                ex.getMessage(),
                "PRODUCT_INSUFFICIENT_QUANTITY"
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
