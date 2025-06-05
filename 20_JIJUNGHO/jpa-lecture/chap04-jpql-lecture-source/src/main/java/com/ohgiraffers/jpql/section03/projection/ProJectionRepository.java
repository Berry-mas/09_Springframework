package com.ohgiraffers.jpql.section03.projection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProJectionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    // 엔터티 프로젝션 : 원하는 객체를 바로 조회할 수 있다.  조회된 엔티티는 영속성 컨텍스트가 관리
    public List<Menu> singleEntityProjection() {
        String jpql = "SELECT m FROM Section03Menu m";
        return entityManager.createQuery(jpql, Menu.class).getResultList();
    }

    // 임베디드 타입 프로젝션 : 조회의 시작점이 될 수 없다. (from 절 사용 불가) 임베디드 타입은 영속성 컨텍스트에서 관리되지 않는다
    public List<MenuInfo> embeddedTypeProjection() {
        String jpql = "SELECT m.menuInfo FROM EmbeddedMenu m";
        return entityManager.createQuery(jpql, MenuInfo.class).getResultList();
    }

    // 스칼라 타입 프로젝션 : 숫자, 문자, 날짜 같은 기본 데이터 타입이다. 스칼라 타입은 영속성 컨텍스트에서 관리되지 않는다
    public List<Object[]> scalarTypeProjection() {
        String jpql = "SELECT c.categoryCode, c.categoryName FROM Section03Category c";
        return entityManager.createQuery(jpql, Object[].class).getResultList();
    }

    // new 명령어를 활용한 프로젝션 : 다양한 종류의 단순 값들을 DTO로 바로 조회하는 방식으로 new 패키지명.DTO명을 쓰면 해당 DTO로 바로 반환받을 수 있다.  new 명령어를 사용한 클래스의 객체는 엔티티가 아니므로 영속성 컨텍스트에서 관리되지 않는다
    public List<CategoryInfo> newCommandProjection () {
        String jpql = "SELECT new com.ohgiraffers.jpql.section03.projection.CategoryInfo(" +
                "c.categoryCode, c.categoryName) FROM Section03Category c";
        return entityManager.createQuery(jpql, CategoryInfo.class).getResultList();
    }

}
