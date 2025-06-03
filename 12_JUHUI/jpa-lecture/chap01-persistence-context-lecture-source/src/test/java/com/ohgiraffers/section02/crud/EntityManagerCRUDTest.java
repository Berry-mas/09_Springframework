package com.ohgiraffers.section02.crud;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EntityManagerCRUDTest {

    private EntityManagerCRUD crud;

    @BeforeEach
    void init(){
        this.crud = new EntityManagerCRUD();
    }

    @DisplayName("메뉴 코드로 메뉴 조회")
    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,3"})
    void testFindMenuByMenuCode(int menuCode, int expected){
        //when
        Menu foundMenu = crud.findMenuByMenuCode(menuCode);

        //then
        assertEquals(expected, foundMenu.getMenuCode());
        System.out.println("foundMenu = " + foundMenu);
    }

    private static Stream<Arguments> newMenu(){
        return Stream.of(
                Arguments.of(
                        "고등어꼬치", 3500, 4, "Y"
                )
        );
    }

    @DisplayName("신규 메뉴 추가")
    @ParameterizedTest
    @MethodSource("newMenu")
    void testRegist(String menuName, int menuPrice, int categoryCode, String orderableStatus){
        // when
        Menu menu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);
        Long count = crud.saveAndReturnAllCount(menu);

        // then
        assertEquals(26, count);
    }

    @DisplayName("메뉴 이름 수정 테스트")
    @ParameterizedTest
    @CsvSource("1,  열무김치라떼")
    void testModifyMenuName(int menuCode, String menuName) {
        // when
        Menu modifiedMenu = crud.modifyMenuName(menuCode, menuName);

        // then
        assertEquals(menuName, modifiedMenu.getMenuName());
    }

    @DisplayName("메뉴 코드로 메뉴 삭제 테스트")
    @ParameterizedTest
    @ValueSource(ints = {105})
    void testRemoveMenu(int menuCode){
        // when
        Long count = crud.removeAndReturnAllCount(menuCode);

        // then
        assertEquals(26, count);
    }

}