package com.microservicespractice.ProductService.mapper;

import com.microservicespractice.ProductService.dto.ProductDTO;
import com.microservicespractice.ProductService.entity.Product;
import com.microservicespractice.ProductService.model.ProductRequest;
import com.microservicespractice.ProductService.model.ProductResponse;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductDTO mapProductToProductDTO(Product product);

    Product mapProductDTOToProduct(ProductDTO productDTO);

    ProductDTO mapProductRequestToProductDTO(ProductRequest productRequest);

    ProductResponse mapProductDTOToProductResponse(ProductDTO productDTO);
}
