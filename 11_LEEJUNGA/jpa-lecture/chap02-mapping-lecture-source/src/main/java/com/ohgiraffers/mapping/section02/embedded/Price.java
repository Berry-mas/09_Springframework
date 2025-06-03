package com.ohgiraffers.mapping.section02.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Price {

    @Column(name = "reqular_price")
    private int reqularPrice;

    @Column(name="discount_rate")
    private double discountRate;

    @Column(name="sell_price")
    private int sellPrice;

    public Price() {
    }

    public Price(int reqularPrice, double discountRate) {
        this.reqularPrice = reqularPrice;
        this.discountRate = discountRate;
    }

    private void validateNagativePrice(int regularPrice) {
        if(regularPrice < 0) {
            throw new IllegalArgumentException("가격은 음수일 수 없습니다.");
        }
    }

    private void validateNegativeDiscountRate(double discountRate) {
        if(discountRate < 0) {
            throw new IllegalArgumentException("할인율은 음수일 수 없습니다.");
        }
    }

    private int calcSellPrice(int regularPrice, double discountRate) {
        return (int) (regularPrice - (regularPrice * discountRate));
    }
}
