package com.ohgiraffers.jpql.section03.projection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*
* Projection : SELECT 절에 조회할 대상을 지정하는 것을 프로젝션이라고 한다.
 * */
@SpringBootTest
class ProJectionRepositoryTest {

    @Autowired
    private ProJectionRepository proJectionRepository;

    @DisplayName("임베디드 타입 프로젝션")
    @Test
    void testEmbeddedTypeProjection() {
        List<MenuInfo> menuInfo = proJectionRepository.embeddedTypeProjection();
        assertNotNull(menuInfo);
    }

    @DisplayName("스칼라 타입 프로젝션")
    @Test
    void testScalarTypeProjection() {
        List<Object[]> categoryInfos = proJectionRepository.scalarTypeProjection();
        assertNotNull(categoryInfos);
        categoryInfos.forEach(
                row -> {
                    for (Object column : row) {
                        System.out.print(column + " ");
                    }
                    System.out.println();
                }
        );
    }

    @DisplayName("new 명령어를 활용한 프로젝션")
    @Test
    void testNewCommandProjection() {
        List<CategoryInfo> categoryInfos = proJectionRepository.newCommandProjection();
        assertNotNull(categoryInfos);

        categoryInfos.forEach(System.out::println);
    }
}