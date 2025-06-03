package com.ohgiraffers.common;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Product> items;  // 쇼핑 카드에 담긴 상품들

    public ShoppingCart() {
        items = new ArrayList<Product>();
    }


    public void addItem(Product item) {
        items.add(item);
    }

    public List<Product> getItems() {
        return items;
    }

}
