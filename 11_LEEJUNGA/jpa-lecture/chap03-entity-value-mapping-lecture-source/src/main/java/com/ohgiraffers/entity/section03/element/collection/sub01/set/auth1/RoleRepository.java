package com.ohgiraffers.entity.section03.element.collection.sub01.set.auth1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository("roleRepository1")
public class RoleRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public Role findById(String id) {
        return entityManager.find(Role.class, id);
    }

    public void registRole(Role role){
        entityManager.persist(role);
    }

}
