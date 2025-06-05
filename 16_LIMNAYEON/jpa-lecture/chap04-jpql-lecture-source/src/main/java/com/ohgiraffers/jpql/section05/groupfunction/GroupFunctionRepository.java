package com.ohgiraffers.jpql.section05.groupfunction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class GroupFunctionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public long countMenuOfCategory(int categoryCode) {
        String jpql = "SELECT COUNT(m.menuCode) FROM Section05Menu m " +
                "WHERE m.categoryCode = :categoryCode";

        return entityManager.createQuery(jpql, Long.class)
                .setParameter("categoryCode", categoryCode)
                .getSingleResult();
    }

    public Long sumMenuPriceOfCategory(int categoryCode){
        String jpql = "SELECT SUM(m.menuPrice) FROM Section05Menu m " +
                "WHERE m.categoryCode = :categoryCode";

        return entityManager.createQuery(jpql, Long.class)
                .setParameter("categoryCode", categoryCode)
                .getSingleResult();
    }
}
