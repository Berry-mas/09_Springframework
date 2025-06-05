package com.ohgiraffers.entity.section03.element.collection.sub02.list.question1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void registQuestion(Question question) {
        entityManager.persist(question);
    }


    public Question findById(Long id) {
        return entityManager.find(Question.class, id);
    }
}
