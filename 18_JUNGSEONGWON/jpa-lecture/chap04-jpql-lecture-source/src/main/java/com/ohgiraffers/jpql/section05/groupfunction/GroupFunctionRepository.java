package com.ohgiraffers.jpql.section05.groupfunction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class GroupFunctionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public long countMenuOfCategory(int categoryCode){
        String jpql = "SELECT COUNT(m.menuCode) FROM Section05Menu m " +
                "WHERE m.categoryCode = :categoryCode";
        return entityManager.createQuery(jpql, Long.class)
                .setParameter("categoryCode", categoryCode)
                .getSingleResult();
    }

    /*
    *   COUNT 외의 그룹함수의 경우 결과 행이 없을 때 null값이 반환되므로
    *   기본자료형으로 다룰 경우 문제가 생긴다. Long or Double등의 Wrapper타입으로 취급
    * */
    public Long sumMenuPriceOfCategory(int categoryCode){
        String jpql = "SELECT SUM(m.menuPrice) FROM Section05Menu m " +
                "WHERE m.categoryCode = :categoryCode";

        return entityManager.createQuery(jpql, Long.class)
                .setParameter("categoryCode", categoryCode)
                .getSingleResult();
    }




}
