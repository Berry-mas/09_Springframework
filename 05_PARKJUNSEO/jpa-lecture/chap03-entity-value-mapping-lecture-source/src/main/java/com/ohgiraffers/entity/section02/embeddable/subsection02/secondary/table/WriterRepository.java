package com.ohgiraffers.entity.section02.embeddable.subsection02.secondary.table;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class WriterRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void registWriter(Writer writer) {
        entityManager.persist(writer);
    }
}
