package com.ohgiraffers.entity.section02.embeddable.subsection03.attribute.override;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void registUser(User user) {
        entityManager.persist(user);
    }
}
