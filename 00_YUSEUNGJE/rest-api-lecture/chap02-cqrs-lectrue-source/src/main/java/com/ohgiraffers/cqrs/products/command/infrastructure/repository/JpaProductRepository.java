package com.ohgiraffers.cqrs.products.command.infrastructure.repository;

import com.ohgiraffers.cqrs.products.command.domain.aggregate.Product;
import com.ohgiraffers.cqrs.products.command.domain.respository.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends ProductRepository, JpaRepository<Product, Long> {
}
