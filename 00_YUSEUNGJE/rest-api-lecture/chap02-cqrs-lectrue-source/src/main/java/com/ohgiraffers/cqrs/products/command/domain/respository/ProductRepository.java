package com.ohgiraffers.cqrs.products.command.domain.respository;

import com.ohgiraffers.cqrs.products.command.domain.aggregate.Product;

import java.util.Optional;

public interface ProductRepository {
    Product save(Product newProduct);

    Optional<Product> findById(Long productCode);

    void deleteById(Long productCode);
}
