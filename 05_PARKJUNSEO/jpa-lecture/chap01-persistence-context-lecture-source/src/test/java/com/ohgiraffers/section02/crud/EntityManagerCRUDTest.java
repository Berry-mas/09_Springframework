package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EntityManagerCRUDTest {

    private EntityManagerCRUD entityManagerCRUD;

    @BeforeEach
    void init() {
        this.entityManagerCRUD = new EntityManagerCRUD();
    }


    @DisplayName("메뉴 코드로 메뉴 조회")
    @ParameterizedTest  // 입력값을 받았다고 가정
    @CsvSource({"1,1", "7,7", "3,3"})
    void testFindMenuByMenuCode(int menuCode, int expected) {
        // when
        Menu foundMenu = entityManagerCRUD.findMenuByMenuCode(menuCode);    //

        // then
        assertEquals(expected, foundMenu.getMenuCode());    // 1번을 넣으면 1번을 들고 올 거예요 하고 예상
        System.out.println("foundMenu = " + foundMenu);

    }

    private static Stream<Arguments> newMenu() {
        return Stream.of(
                Arguments.of(
                        "갈비찜", 8500, 4, "Y"
                )
        );
    }

    @DisplayName("신규 메뉴 추가")
    @ParameterizedTest
    @MethodSource("newMenu")
    void testRegist(String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        // given
        // @MethodSource("newMenu")로 받음

        // when
        Menu menu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);
        Long count = entityManagerCRUD.saveAndReturnAllCount(menu);

        // then
        assertEquals(32, count);
    }

    @DisplayName("메뉴 이름 수정 테스트")
    @ParameterizedTest
    @CsvSource("1, 변경된 이름 두번째") // 여기서 값을 주고 있음 (// given)
    void testModifyMenuName(int menuCode, String menuName) {
        // when
        Menu modifyMenu = entityManagerCRUD.modifyMenuName(menuCode, menuName);

        // then
        assertEquals(menuName, modifyMenu.getMenuName());
    }

    @DisplayName("메뉴 코드로 메뉴 삭제 테스트")
    @ParameterizedTest
    @ValueSource(ints = {44})
    void testRemoveMenu(int menuCode) {
        // when
        long count = entityManagerCRUD.removeAndReturnAllCount(menuCode);
        // then
        assertEquals(32, count);
    }

}