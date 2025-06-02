package com.ohgiraffers.associationmapping.section03.bidirection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BiDirectionServiceTest {

    @Autowired
    private BiDirectionService biDirectionService;
    
    @DisplayName("양방향 연관관계 매핑 조회 테스트1 (연관관계의 주인인 객체)")
    @Test
    void biDirectionFindTest1(){
        // given 
        int menuCode = 10;
        // when
        /* 진짜 연관관계 : 처음 조회 시부터 조인한 결과를 인출해 온다. */
        Menu foundMenu = biDirectionService.findMenu(menuCode);
        // then
        Assertions.assertEquals(menuCode, foundMenu.getMenuCode());
        System.out.println("foundMenu ===>> " + foundMenu);
    }

    @DisplayName("양방향 연관관계 매핑 조회 테스트2 (연관관계의 주인이 아닌 객체)")
    @Test
    void biDirectionFindTest2(){
        // given
        int categoryCode = 10;
        // when
        Category foundCategory = biDirectionService.findCategory(categoryCode);
        // then
        Assertions.assertEquals(categoryCode, foundCategory.getCategoryCode());
       // System.out.println("foundCategory ===>> " + foundCategory);
    }
}