package com.balaji.cqrs.get.cqrs.repository;

import com.balaji.cqrs.get.cqrs.entity.ProductDom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDom, Long> {
}
