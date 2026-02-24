package com.microservicespractice.ProductService.exception;

import com.microservicespractice.ProductService.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductServiceException(ProductNotFoundException customException) {
        return new ResponseEntity<>( new ErrorResponse().builder()
                .errorCode(customException.getErrorCode())
                .errorMessage(customException.getMessage())
                .build(), HttpStatus.NOT_FOUND);
    }
}
