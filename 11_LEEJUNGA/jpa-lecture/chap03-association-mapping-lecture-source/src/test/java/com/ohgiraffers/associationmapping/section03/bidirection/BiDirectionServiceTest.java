package com.ohgiraffers.associationmapping.section03.bidirection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BiDirectionServiceTest {

    @Autowired
    private BiDirectionService biDirectionService;

    @DisplayName("양방향 연관관계 매핑 조회 테스트1 (연관관계 주인인 객체)")
    @Test
    void biDirectionFindTest1(){
        // given
        int menuCode = 10;

        // when
        /*진짜 연관관계 : 처음 조회 시부터 조인한 결과를 인출해 온다.*/
        Menu foundMenu = biDirectionService.findMenu(menuCode);

        // then
        Assertions.assertEquals(menuCode, foundMenu.getMenuCode());
        System.out.println("found menu ===> " + foundMenu);
    }

    @DisplayName("양방향 연관관계 매핑 조회 테스트 2 (연관관계의 주인이 아닌 객체)")
    @Test
    void biDirectionFindTest2(){
        // given
        int categoryCode = 10;

        //when
        Category foundCategory = biDirectionService.findCategory(categoryCode);

        // then
        Assertions.assertEquals(categoryCode, foundCategory.getCategoryCode());
        System.out.println("found category ===> " + foundCategory);
    }

    private static Stream<Arguments> getMenuInfo() {
        return Stream.of(
                Arguments.of(111, "스테이크 크림 파수트", 9000, "Y")
        );
    }

    @DisplayName("양방향 연관관계 주인 객체를 이용한 삽입 테스트")
    @ParameterizedTest
    @MethodSource("getMenuInfo")
    void biDirectionInsertTest1(int menuCode, String menuName, int menuPrice, String orderableStatus) {
        // given
        Category category = biDirectionService.findCategory(4); // 영속화
        Menu menu = new Menu(menuCode, menuName, menuPrice, category, orderableStatus);

        // when
        // then
        assertDoesNotThrow(
                () -> biDirectionService.registMenu(menu)
        );
    }

    private static Stream<Arguments> getCategoryInfo() {
        return Stream.of(
                Arguments.of(111, "양방향 카테고리", null)
        );
    }

    @DisplayName("양방향 연관관계 주인이 아닌 객체를 이용한 삽입 테스트")
    @ParameterizedTest
    @MethodSource("getCategoryInfo")
    void biDirectionInsertTest2(int categoryCode, String categoryName, Integer refCategoryCode) {
        // given
        Category category = new Category(categoryCode, categoryName, refCategoryCode);
        // when
        biDirectionService.registCategory(category);
        // then
        Category foundCategory = biDirectionService.findCategory(categoryCode);
        Assertions.assertNotNull(foundCategory);
    }
}