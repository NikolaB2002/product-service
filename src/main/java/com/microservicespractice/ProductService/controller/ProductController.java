package com.microservicespractice.ProductService.controller;

import com.microservicespractice.ProductService.mapper.ProductMapper;
import com.microservicespractice.ProductService.model.ProductRequest;
import com.microservicespractice.ProductService.model.ProductResponse;
import com.microservicespractice.ProductService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private static final ProductMapper MAPPER = Mappers.getMapper((ProductMapper.class));
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest productRequest){
        return new ResponseEntity<>(MAPPER.mapProductDTOToProductResponse(productService.addProduct(MAPPER.mapProductRequestToProductDTO(productRequest))), HttpStatus.CREATED);
    };

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId){
        return new ResponseEntity<>(MAPPER.mapProductDTOToProductResponse(productService.getProductDTOById(productId)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> reduceProductQuantity(@PathVariable("id") long productId, @RequestParam long productQuantity){
        productService.reduceProductQuantity(productId, productQuantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
