package com.ohgiraffers.section01.entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class EntityManagerFactoryGeneratorTest {

    @Test
    @DisplayName("엔터티 매니저 팩토리 생성 확인")
    void testGenerateEntityManagerFactory() {

        // when
        EntityManagerFactory factory = EntityManagerFactoryGenerator.getInstance();

        // then
        assertNotNull(factory);
    }

    @Test
    @DisplayName("엔터티 매니저 팩토리 싱글톤 인스턴스 확인")
    // 공장은 하나이기를 바람 (싱글톤 => 동일성 체크)
    void testEntityManagerFactorySingleton() {
        // when
        EntityManagerFactory factory1 = EntityManagerFactoryGenerator.getInstance();
        EntityManagerFactory factory2 = EntityManagerFactoryGenerator.getInstance();

        // then
        assertEquals(factory1.hashCode(), factory2.hashCode());
    }

    @Test
    @DisplayName("엔터티 매니저 생성 확인")
    void testGenerateEntityManager() {
        // when
        EntityManager manager = EntityManagerGenerator.getInstance();

        // then
        assertNotNull(manager);
    }

    @Test
    @DisplayName("엔터티 매니저 스코프 확인")
    // 요청할 때마다 할당 => 동일하지 않음 (주소값이 다름)
    void testEntityManagerScope() {
        // when
        EntityManager entityManager1 = EntityManagerGenerator.getInstance();
        EntityManager entityManager2 = EntityManagerGenerator.getInstance();

        // then
        assertNotEquals(entityManager1, entityManager2);
        assertNotEquals(entityManager1.hashCode(), entityManager2.hashCode());
    }


}