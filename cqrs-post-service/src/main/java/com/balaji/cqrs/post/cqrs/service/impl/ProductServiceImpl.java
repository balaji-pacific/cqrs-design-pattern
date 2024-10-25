package com.balaji.cqrs.post.cqrs.service.impl;

import com.balaji.cqrs.post.cqrs.dto.ProductDto;
import com.balaji.cqrs.post.cqrs.entity.ProductDom;
import com.balaji.cqrs.post.cqrs.repository.ProductRepository;
import com.balaji.cqrs.post.cqrs.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public KafkaTemplate<String, Object> kafkaTemplate;


    @Override
    public ProductDto createProduct(ProductDto productDto) {
        ProductDom productDom = ProductDom.builder()
                .description(productDto.getDescription())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .build();
        productDom = productRepository.save(productDom);
        productDto =  ProductDto.builder()
                .description(productDom.getDescription())
                .id(productDom.getId())
                .price(productDom.getPrice())
                .name(productDom.getName())
                .eventType("Create")
                .build();
        kafkaTemplate.send("product-topic", productDto);
        return productDto;
    }

    @Override
    public ProductDto updateProduct(ProductDto updatedProductDto) {
        ProductDom existingProduct = productRepository.findById(Long.valueOf(updatedProductDto.getId())).get();
        existingProduct.setDescription(updatedProductDto.getDescription());
        existingProduct.setName(updatedProductDto.getName());
        existingProduct.setPrice(updatedProductDto.getPrice());
        existingProduct = productRepository.save(existingProduct);
        updatedProductDto =  ProductDto.builder()
                .description(existingProduct.getDescription())
                .id(existingProduct.getId())
                .price(existingProduct.getPrice())
                .name(existingProduct.getName())
                .eventType("Update")
                .build();
        kafkaTemplate.send("product-topic", updatedProductDto);
        return updatedProductDto;
    }
}
