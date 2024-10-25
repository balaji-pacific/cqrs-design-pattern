package com.balaji.cqrs.post.cqrs.controller;

import com.balaji.cqrs.post.cqrs.dto.ProductDto;
import com.balaji.cqrs.post.cqrs.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class CQRSProductController {

    @Autowired
    public ProductService productService;

    @PostMapping("create-product")
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }

    @PutMapping("update-product")
    public ProductDto updateProduct(@RequestBody ProductDto productDto){
        return productService.updateProduct(productDto);
    }
}
