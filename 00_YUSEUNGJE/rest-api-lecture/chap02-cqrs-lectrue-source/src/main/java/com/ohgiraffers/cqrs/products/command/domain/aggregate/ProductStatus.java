package com.ohgiraffers.cqrs.products.command.domain.aggregate;

public enum ProductStatus {
    USABLE,     // 주문 가능
    DISABLE,    // 주문 불가
    DELETED     // 삭제
}
