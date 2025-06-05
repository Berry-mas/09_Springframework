package com.ohgiraffers.jpql.section06.join;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class joinRepositoryTest {

    @Autowired
    joinRepository joinRepository;

    @DisplayName("inner join 테스트")
    @Test
    void testSelectByInnerJoin() {
        List<Menu> menus = joinRepository.selectByInnerJoin();
        assertNotNull(menus);
    }

    @DisplayName("join fetch 테스트")
    @Test
    void testSelectByFetchJoin() {
        List<Menu> menus = joinRepository.selectByFetchJoin();
        assertNotNull(menus);
    }

    @DisplayName("outer join 테스트")
    @Test
    void testSelectByOuterJoin() {
        List<Object[]> menuList =  joinRepository.selectByOuterJoin();
        assertNotNull(menuList);

        menuList.forEach((row) -> {
            for(Object column : row) {
                System.out.print(column + " ");
            }
            System.out.println ();
        });
    }

    @DisplayName("collection join")
    @Test
    void testSelectByCollectionJoin() {
        List<Object[]> menuList =  joinRepository.selectByCollectionJoin();
        assertNotNull(menuList);
        menuList.forEach((row) -> {
            for(Object column : row) {
                System.out.print(column + " ");
            }
            System.out.println ();
        });
    }

    @DisplayName("theta join")
    @Test
    void testSelectByThetaJoin() {
        List<Object[]> menuList =  joinRepository.selectByThetaJoin();
        assertNotNull(menuList);
        menuList.forEach((row) -> {
            for(Object column : row) {
                System.out.print(column + " ");
            }
            System.out.println ();
        });
    }
}