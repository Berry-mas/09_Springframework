package com.ohgiraffers.section03.properties.subsection01.properties;

import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import com.ohgiraffers.section02.subsection02.annotation.java.ContextConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        Product carpBread = context.getBean("carpBread", Product.class);
        Product milk = context.getBean("milk", Product.class);
        Product water = context.getBean("water", Product.class);

        System.out.println("쇼피 카트 객체 꺼내기 전");
        ShoppingCart shoppingCart = context.getBean("cart", ShoppingCart.class);
        System.out.println("쇼핑 카드 객체 꺼낸 다음");
        shoppingCart.addItem(carpBread);
        shoppingCart.addItem(milk);
        System.out.println("cart에 담긴 물품 : " + shoppingCart.getItems());

        // 다음 손님 등장
        ShoppingCart shoppingCart2 = context.getBean("cart", ShoppingCart.class);
        shoppingCart2.addItem(water);
        System.out.println("cart2에 담긴 물품 : " + shoppingCart2.getItems());
    }
}
