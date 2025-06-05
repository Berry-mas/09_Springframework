package com.ohgiraffers.jpql.section05.groupfunction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GroupFunctionRepositoryTest {

    @Autowired
    private GroupFunctionRepository groupFunctionRepository;

    @DisplayName("특정 카테고리에 해당하는 메뉴 수 조회")
    @Test
    void testCountMenuOfCategory() {
        // given
        int categoryCode = 7777;

        // when
        long menuCount = groupFunctionRepository.countMenuOfCategory(categoryCode);

        // then
        System.out.println("menuCount = " + menuCount);
        assertTrue(menuCount >= 0);
    }

    @DisplayName("특정 카테고리에 해당하는 메뉴 가격의 합 조회")
    @Test
    void testSumMenuPriceOfCategory() {
        int categoryCode = 4;

        assertDoesNotThrow(() -> {
            Long sumMenuPrice = groupFunctionRepository.sumMenuPriceOfCategory(categoryCode);
            System.out.println("sumMenuPrice = " + sumMenuPrice);
        });
    }
}