package com.ohgiraffers.section02.subsection01.initdestroy.java;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class ContextConfiguration {

    @Bean
    public Product carpBread() {
        System.out.println("붕어빵 생성 시점");
        return new Bread("붕어빵", 1000, new java.util.Date());
    }

    @Bean
    public Product milk() {
        System.out.println("딸기우유 생성 시점");
        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean
    public Product water() {
        System.out.println("물 생성 시점");
        return new Beverage("지리산 절벽 암반수", 3000, 400);
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart cart(){
        System.out.println("쇼핑 카트 생성 시점");
        return new ShoppingCart();
    }

    @Bean(initMethod = "openShop", destroyMethod = "closeShop")
    public Owner owner(){
        return new Owner();
    }
}
