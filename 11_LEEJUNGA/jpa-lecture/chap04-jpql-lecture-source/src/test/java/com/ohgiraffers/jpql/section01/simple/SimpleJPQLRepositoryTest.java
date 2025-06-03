package com.ohgiraffers.jpql.section01.simple;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimpleJPQLRepositoryTest {

    @Autowired
    private SimpleJPQLRepository simpleJPQLRepository;

    @DisplayName("TypedQuery를 이용한 단일행, 단일 컬럼 조회")
    @Test
    void testSelectSingleMenuByTypedQuery() {
        String menuName = simpleJPQLRepository.selectSingleMenuByTypedQuery();
        assertEquals("한우딸기국밥", menuName);
    }

    @DisplayName("Query를 이용한 단일행, 단일 컬럼 조회")
    @Test
    void testSelectSingleMenuByQuery() {
        Object menuName = simpleJPQLRepository.selectSingleMenuByQuery();
        assertEquals("한우딸기국밥", menuName);
    }

    @DisplayName("Query를 이용한 단일행 조회")
    @Test
    void testSelectSingleRowByTypedQuery() {
        Menu menu = simpleJPQLRepository.selectSingleRowByTypeQuery();
        assertNotNull(menu);
        assertEquals("한우딸기국밥", menu.getMenuName());
    }

    @DisplayName("TypledQuery를 이용한 다중행 조회")
    @Test
    void testSelectSingleRowByQuery() {
        List<Menu> menuList = simpleJPQLRepository.selectMultiRowByTypedQuery();
        assertNotNull(menuList);
    }

    @Test
    void testSelctUsingDistinct() {

    }

    @Test
    void testSelectUsingIn() {
        List<Menu> menuList = simpleJPQLRepository.selectUsingIn();
        assertNotNull(menuList);
    }
}