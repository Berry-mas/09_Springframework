package com.ohgiraffers.cqrs.products.command.application.controller;

import com.ohgiraffers.cqrs.common.dto.ApiResponse;
import com.ohgiraffers.cqrs.products.command.application.dto.request.ProductCreateRequest;
import com.ohgiraffers.cqrs.products.command.application.dto.request.ProductUpdateRequest;
import com.ohgiraffers.cqrs.products.command.application.dto.response.ProductCommandResponse;
import com.ohgiraffers.cqrs.products.command.application.service.ProductCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductCommandController {

    private final ProductCommandService productCommandService;

    @PostMapping("/products")
    public ResponseEntity<ApiResponse<ProductCommandResponse>> createProduct(
            @RequestPart @Validated ProductCreateRequest productCreateRequest,
            @RequestPart MultipartFile productImg
            ){
        log.info("Creating product ===>>{}", productCreateRequest);
        log.info("Product image ===>>{}", productImg);
        Long productCode = productCommandService.createProduct(productCreateRequest, productImg);

        ProductCommandResponse response = ProductCommandResponse.builder()
                .productCode(productCode).build();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(response));
    }

    @PutMapping("/products/{productCode}")
    public ResponseEntity<ApiResponse<Void>> updateProduct(
            @PathVariable Long productCode,
            @RequestPart @Validated ProductUpdateRequest productUpdateRequest,
            @RequestPart(required = false) MultipartFile productImg
    ) {
        productCommandService.updateProduct(productCode, productUpdateRequest, productImg);

        return ResponseEntity
                .ok(ApiResponse.success(null));
    }

    @DeleteMapping("/products/{productCode}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Long productCode) {

        productCommandService.deleteProduct(productCode);

        return ResponseEntity.ok(ApiResponse.success(null));
    }
}
