package com.balaji.cqrs.post.cqrs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductDto {
    private String eventType;
    private String id;
    private String name;
    private String description;
    private String price;
}
