package com.balaji.cqrs.post.cqrs.repository;

import com.balaji.cqrs.post.cqrs.entity.ProductDom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDom, Long> {
}