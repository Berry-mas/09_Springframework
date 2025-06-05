package com.ohgiraffers.entity.section04.inheritance.section01.single.table;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class TableRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void registDeveloperAndManager(Developer developer, Manager manager) {
        entityManager.persist(developer);
        entityManager.persist(manager);
    }
}
