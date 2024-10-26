package com.balaji.cqrs.get.cqrs.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("PRODUCT_QUERY")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductDom {
    @Id
    private String id;
    private String name;
    private String description;
    private String price;
}
