package com.ohgiraffers.entity.section03.element.collection.sub01.set.auth2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository("roleRepository2")
public class RoleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Role findById(String id) {
        return entityManager.find(Role.class, id);
    }

    public void registRole(Role role) {
        entityManager.persist(role);
    }
}
