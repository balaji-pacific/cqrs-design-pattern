package com.balaji.cqrs.post.cqrs.service;

import com.balaji.cqrs.post.cqrs.dto.ProductDto;
import com.balaji.cqrs.post.cqrs.entity.ProductDom;

public interface ProductService {

    public ProductDto createProduct(ProductDto productDto);

    public ProductDto updateProduct(ProductDto updatedProductDto);

}
