package com.ohgiraffers.cqrs.products.command.application.service;

import com.ohgiraffers.cqrs.common.service.FileStorageService;
import com.ohgiraffers.cqrs.exception.BusinessException;
import com.ohgiraffers.cqrs.exception.ErrorCode;
import com.ohgiraffers.cqrs.products.command.application.dto.request.ProductCreateRequest;
import com.ohgiraffers.cqrs.products.command.application.dto.request.ProductUpdateRequest;
import com.ohgiraffers.cqrs.products.command.domain.aggregate.Product;
import com.ohgiraffers.cqrs.products.command.domain.aggregate.ProductStatus;
import com.ohgiraffers.cqrs.products.command.domain.respository.ProductRepository;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ProductCommandService {

    private final ProductRepository productRepository;
    private final FileStorageService fileStorageService;
    private final ModelMapper modelMapper;

    @Value("${image.image-url}")
    private String IMAGE_URL;

    /***
     * 상품등록
     * @param productCreateRequest
     * @param productImg
     * @return
     */
    @Transactional
    public Long createProduct(ProductCreateRequest productCreateRequest, MultipartFile productImg) {
        // 1. File 저장 => FileStorageService를 이용
        String replaceFileName = fileStorageService.storeFile(productImg);

        // 2. DTO -> Entity 변환
        Product newProduct = modelMapper.map(productCreateRequest, Product.class);
        newProduct.changeProductImageUrl(IMAGE_URL + replaceFileName);
        // 3. productRepository entity save
        Product product = productRepository.save(newProduct);

        return product.getProductCode();
    }

    @Transactional
    public void updateProduct(Long productCode, ProductUpdateRequest productUpdateRequest, MultipartFile productImg) {
        // 상품코드를 이용해서 jpa를 통해서 데이터베이스에 있는 데이터를 조회하고, 영속성컨텍스트에 넣어둔다.
        Product product = productRepository.findById(productCode)
                .orElseThrow(() -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND));

        /* 파일이 넘어오면 수정, 넘어오지 않으면 기존 파일 그대로 유지 */
        if(productImg != null) {
            String replaceFileName = fileStorageService.storeFile(productImg);
            // 기존 이미지 URL에서 파일명 추출해서 삭제
            String oldFileName = product.getProductImageUrl().replace(IMAGE_URL, "");
            fileStorageService.deleteFile(oldFileName);
            // 엔터티 파일 url 변경
            product.changeProductImageUrl(replaceFileName);
        }

        product.updateProductDetails(
                productUpdateRequest.getProductName(),
                productUpdateRequest.getProductPrice(),
                productUpdateRequest.getProductDescription(),
                productUpdateRequest.getCategoryCode(),
                productUpdateRequest.getProductStock(),
                ProductStatus.valueOf(productUpdateRequest.getStatus())
        );
    }

    /* 상품 삭제 : (soft delete : @SqlDelete 어노테이션 활용) */
    @Transactional
    public void deleteProduct(Long productCode) {

       productRepository.deleteById(productCode);
    }
}
