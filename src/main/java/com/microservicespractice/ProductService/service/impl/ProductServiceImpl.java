package com.microservicespractice.ProductService.service.impl;

import com.microservicespractice.ProductService.dto.ProductDTO;
import com.microservicespractice.ProductService.exception.ProductNotFoundException;
import com.microservicespractice.ProductService.mapper.ProductMapper;
import com.microservicespractice.ProductService.repository.ProductRepository;
import com.microservicespractice.ProductService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private static final ProductMapper MAPPER = Mappers.getMapper((ProductMapper.class));

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        return MAPPER.mapProductToProductDTO(productRepository.save(MAPPER.mapProductDTOToProduct(productDTO)));
    }

    @Override
    public ProductDTO getProductDTOById(long productId) {
        return MAPPER.mapProductToProductDTO(productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product with this id not found!!!", "PRODUCT_NOT_FOUND")));
    }
}
