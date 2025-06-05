package com.ohgiraffers.jpql.section03.projection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectionRepositoryTest {

    @Autowired
    private ProjectionRepository projectionRepository;

    @DisplayName("임베디드 타입 프로젝션")
    @Test
    void testEmbeddedTypeProjection() {
        List<MenuInfo> menuInfos = projectionRepository.emmbddedTypeProjection();
        assertNotNull( menuInfos );
    }

    @DisplayName("스칼라 타입 프로젝션")
    @Test
    void testScalarTypeProjection() {
        List<Object[]> categoryInfos = projectionRepository.scalarTypeProjcetion();
        assertNotNull( categoryInfos );
        categoryInfos.forEach( row -> {
            for(Object column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        });
    }

    @DisplayName("new 명령어 프로젝션")
    @Test
    void testNewCommandProjection() {
        List<CategoryInfo> categoryInfos = projectionRepository.newCommandProjcetion();
        assertNotNull( categoryInfos );
        categoryInfos.forEach(System.out::println);
    }

}