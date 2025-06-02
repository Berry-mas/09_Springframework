package com.ohgiraffers.jpql.section01.simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleJPQLRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public String selectSingleMenuByTypedQuery(){
        String jpql = "SELECT m.menuName FROM Section01Menu as m WHERE m.menuCode = 8";
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        String resultMenuName = query.getSingleResult();
        return resultMenuName;
    }

    public Object selectSingleMenuByQuery(){
        String jpql = "SELECT m.menuName FROM Section01Menu as m WHERE m.menuCode = 8";
        Query query = entityManager.createQuery(jpql);
        Object resultMenuName = query.getSingleResult();
        return resultMenuName;
    }
}
