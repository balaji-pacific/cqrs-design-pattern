package com.balaji.cqrs.get.cqrs.repository;

import com.balaji.cqrs.get.cqrs.entity.ProductDom;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductDom, String> {
}
