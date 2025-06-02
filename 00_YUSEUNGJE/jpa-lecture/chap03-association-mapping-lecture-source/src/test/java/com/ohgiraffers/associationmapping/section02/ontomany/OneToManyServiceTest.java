package com.ohgiraffers.associationmapping.section02.ontomany;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OneToManyServiceTest {

    @Autowired
    private OneToManyService oneToManyService;

    @DisplayName("1:N 연관관계 객체 그래프 탐색을 이용한 조회 테스트")
    @Test
    void oneToManyFindTest(){
        // given
        int categoryCode = 4;
        // when
        Category category = oneToManyService.findCategory(categoryCode);
        // then
        Assertions.assertNotNull(category);
    }

}