package com.ohgiraffers.common;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Beverage extends Product {

    private int capacity;       // 용량

    public Beverage() {
    }

    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }

    public String toString() {
        return super.toString() + "  " + capacity;
    }
}
