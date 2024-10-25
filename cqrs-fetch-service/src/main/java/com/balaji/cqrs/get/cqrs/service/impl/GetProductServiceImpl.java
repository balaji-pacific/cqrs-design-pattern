package com.balaji.cqrs.get.cqrs.service.impl;

import com.balaji.cqrs.get.cqrs.entity.ProductDom;
import com.balaji.cqrs.get.cqrs.repository.ProductRepository;
import com.balaji.cqrs.post.cqrs.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetProductServiceImpl {
    @Autowired
    ProductRepository productRepository;

    public List<ProductDto> getProductDetails(){
        List<ProductDom> productDoms = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<ProductDto>();
        productDoms.stream().forEach(productDom -> {
            productDtos.add(ProductDto.builder()
                            .id(productDom.getId())
                            .description(productDom.getDescription())
                            .name(productDom.getName())
                            .price(productDom.getPrice())
                    .build());
        });
        return productDtos;
    }

    @KafkaListener(topics =  "product-topic", groupId = "product-event-group")
    public void processProductEvents(ProductDto productDto){
        if(productDto.getEventType().equalsIgnoreCase("Create")){
            ProductDom productDom = ProductDom.builder()
                    .description(productDto.getDescription())
                    .name(productDto.getName())
                    .price(productDto.getPrice())
                    .build();
            productDom = productRepository.save(productDom);
        }
        if(productDto.getEventType().equalsIgnoreCase("Update")){
            ProductDom existingProduct = productRepository.findById(Long.valueOf(productDto.getId())).get();
            existingProduct.setDescription(productDto.getDescription());
            existingProduct.setName(productDto.getName());
            existingProduct.setPrice(productDto.getPrice());
            existingProduct = productRepository.save(existingProduct);
        }

    }
}
