package com.ohgiraffers.jpql.section06.join;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JoinRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /*
     * 일반 조인 : 일반적인 SQL 조인을 의미한다. (내부 조인, 외부 조인, 컬렉션 조인, 세타 조인 등)
     * */

    // inner join
    public List<Menu> selectByInnerJoin() {
        String jpql = "SELECT m FROM Section06Menu m JOIN m.category c";
        return entityManager.createQuery(jpql, Menu.class).getResultList();
    }

    // outer join
    public List<Object[]> selectByOuterJoin() {
        String jpql = "SELECT m.menuName, c.categoryName FROM Section06Menu m RIGHT JOIN m.category c";
        return entityManager.createQuery(jpql).getResultList();
    }

    // collection join
    public List<Object[]> selectByCollectionJoin() {
        String jpql = "SELECT c.categoryName, m.menuName FROM Section06Category c LEFT JOIN c.menuList m";
        return entityManager.createQuery(jpql).getResultList();
    }

    // theta join
    public List<Object[]> selectByThetaJoin() {
        String jpql = "SELECT c.categoryCode, m.menuName FROM Section06Category c, Section06Menu m";
        return entityManager.createQuery(jpql).getResultList();
    }

    // fetch join
    public List<Menu> selectByFetchJoin() {
        // fetch : JPQL에서 성능 최적화를 위해 사용하는 기능으로 연관 엔티티나 컬렉션을 한 번에 조회한다.
        String jpql = "SELECT m FROM Section06Menu m JOIN FETCH m.category c";
        return entityManager.createQuery(jpql, Menu.class).getResultList();
    }


}
