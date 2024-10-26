package com.balaji.cqrs.get.cqrs.controller;

import com.balaji.cqrs.get.cqrs.entity.ProductDom;
import com.balaji.cqrs.get.cqrs.service.GetProductService;
import com.balaji.cqrs.post.cqrs.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product/")
public class CQRSGetController {
    @Autowired
    GetProductService  productService;

    @GetMapping("get-all-products")
    List<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

}
