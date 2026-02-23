package com.microservicespractice.ProductService.service.impl;

import com.microservicespractice.ProductService.entity.Product;
import com.microservicespractice.ProductService.exception.ProductServiceCustomException;
import com.microservicespractice.ProductService.model.ProductRequest;
import com.microservicespractice.ProductService.model.ProductResponse;
import com.microservicespractice.ProductService.repository.ProductRepository;
import com.microservicespractice.ProductService.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.*;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding product...");

        Product product
                = Product.builder()
                .productName(productRequest.getName())
                .productPrice(productRequest.getPrice())
                .productQuantity(productRequest.getQuantity())
                .build();

        productRepository.save(product);
        log.info("Product created");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        log.info("Getting product by id {}", productId);

        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductServiceCustomException("Product with this id not found!!!", "PRODUCT_NOT_FOUND"));
        ProductResponse productResponse = new ProductResponse();
        copyProperties(product, productResponse);

        return productResponse;
    }
}
