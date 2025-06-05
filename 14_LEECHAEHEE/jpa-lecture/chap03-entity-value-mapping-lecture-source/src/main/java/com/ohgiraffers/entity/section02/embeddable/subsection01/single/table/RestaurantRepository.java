package com.ohgiraffers.entity.section02.embeddable.subsection01.single.table;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Restaurant restaurant) {
        entityManager.persist(restaurant);
    }
}
