package com.ohgiraffers.associationmapping.section02.onetomany;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OneToManyServiceTest {

    @DisplayName("1:N 연관관계 객체 그래프 탐색을 이용한 조회 테스트")
    @Test
    void oneToManyFindTest() {
        //given
        int categoryCode = 10;

        //when
        Category category = oneToManyService.findCategory(categoryCode);

        //then
        Assertions.assertNotNull(category);
    }

}