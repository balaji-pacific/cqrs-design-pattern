package com.balaji.cqrs.post.cqrs.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductDto {

    private String eventType;
    private Integer id;
    private String name;
    private String description;
    private String price;
}
