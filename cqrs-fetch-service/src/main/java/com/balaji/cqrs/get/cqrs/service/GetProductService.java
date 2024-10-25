package com.balaji.cqrs.get.cqrs.service;

import com.balaji.cqrs.post.cqrs.dto.ProductDto;

import java.util.List;

public interface GetProductService {

    public List<ProductDto> getProductDetails();
}
