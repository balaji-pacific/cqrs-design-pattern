package com.balaji.cqrs.get.cqrs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUCT_QUERY")
@Builder
public class ProductDom {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private String price;
}
