package com.ohgiraffers.entity.section03.element.collection.sub03.map.setting1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserSettingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void registUserSetting(UserSetting userSetting) {
        entityManager.persist(userSetting);
    }
}
