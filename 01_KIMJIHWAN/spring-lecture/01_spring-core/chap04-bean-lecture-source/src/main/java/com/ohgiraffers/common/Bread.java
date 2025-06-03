package com.ohgiraffers.common;

import lombok.*;

import java.util.Date;

@Getter
@Setter
public class Bread extends Product{
    private java.util.Date bakedDate;      // 생산시간

    public Bread() {
    }

    public Bread(String name, int price, Date bakedDate) {
        super(name, price);
        this.bakedDate = bakedDate;
    }

    @Override
    public String toString() {
        return super.toString() + "  " + this.bakedDate;
    }
}
