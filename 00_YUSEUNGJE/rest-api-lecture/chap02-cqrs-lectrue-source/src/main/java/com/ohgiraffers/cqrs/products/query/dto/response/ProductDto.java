package com.ohgiraffers.cqrs.products.query.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long productCode;
    private String productName;
    private Long productPrice;
    private String productDescription;
    private CategoryDto category;
    private String productImageUrl;
    private Long productStock;
}
