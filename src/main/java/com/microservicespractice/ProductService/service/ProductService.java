package com.microservicespractice.ProductService.service;

import com.microservicespractice.ProductService.model.ProductRequest;
import com.microservicespractice.ProductService.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);
}
