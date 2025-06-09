package com.ohgiraffers.cqrs.products.query.controller;

import com.ohgiraffers.cqrs.common.dto.ApiResponse;
import com.ohgiraffers.cqrs.products.query.dto.request.ProductSearchRequest;
import com.ohgiraffers.cqrs.products.query.dto.response.ProductDetailResponse;
import com.ohgiraffers.cqrs.products.query.dto.response.ProductListResponse;
import com.ohgiraffers.cqrs.products.query.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductQueryController {

    private final ProductQueryService productQueryService;

    @GetMapping("/products/{productCode}")
    public ResponseEntity<ApiResponse<ProductDetailResponse>> getProduct(@PathVariable Long productCode) {
        ProductDetailResponse response = productQueryService.getProduct(productCode);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @GetMapping("/products")
    public ResponseEntity<ApiResponse<ProductListResponse>> getProducts(
            ProductSearchRequest productSearchRequest
    ) {
        log.info("[ProductQueryController] getProducts productSearchRequest.productName ==>> {}", productSearchRequest.getProductName());
        ProductListResponse response = productQueryService.getProducts(productSearchRequest);
        return ResponseEntity.ok(ApiResponse.success(response));
    }
}
