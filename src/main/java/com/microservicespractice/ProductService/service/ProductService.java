package com.microservicespractice.ProductService.service;

import com.microservicespractice.ProductService.dto.ProductDTO;

public interface ProductService {
    ProductDTO addProduct(ProductDTO productDTO);

    ProductDTO getProductDTOById(long productId);

    void reduceProductQuantity(long productId, long productQuantity);
}
