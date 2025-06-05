package com.ohgiraffers.entity.section04.inheritance.section03.table.per.clazz;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClazzRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public void registDeveloperAndManager(Developer developer, Manager manager) {
        entityManager.persist(developer);
        entityManager.persist(manager);
    }

    public List<Employee> selectEmployeeAll(String jpql) {
        TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }
}
