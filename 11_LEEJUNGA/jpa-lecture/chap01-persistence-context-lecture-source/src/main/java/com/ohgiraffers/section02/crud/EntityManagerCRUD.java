package com.ohgiraffers.section02.crud;

import com.ohgiraffers.section01.entitymanager.EntityManagerGenerator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EntityManagerCRUD {

    private EntityManager entityManager;

    /* 1. 특정 메뉴 코드로 메뉴를 조회하는 기능 */
    public Menu findMenuByMenuCode(int menuCode) {
        entityManager = EntityManagerGenerator.getInstance();
        return entityManager.find(Menu.class, menuCode);
    }

    /* 2. 새로운 메뉴 저장하는 기능 */
    public Long saveAndReturnAllCount(Menu newMenu){
        entityManager = EntityManagerGenerator.getInstance();

        /* DML(inser,update,delete) -> 트랜잭션 */
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(newMenu);

        transaction.commit();
        return  getCount(entityManager);
    }

    private Long getCount(EntityManager entityManager) {
        // JPQL
        return entityManager.createQuery("SELECT COUNT(*) FROM Section02Menu", Long.class).getSingleResult();
    }

    /* 3. 메뉴 이름 수정 기능 */
    public Menu modifyMenuName(int menuCode, String newMenuName) {
        entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);  // 조회쿼리 발생

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        foundMenu.setMenuName(newMenuName); // update쿼리 발생

        transaction.commit();
        return foundMenu;
    }

    /* 4. 특정 메뉴 코드로 메뉴 삭제하는 기능 */
    public long removeAndReturnAllCount(int menuCode) {
        entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(foundMenu);

        transaction.commit();
        return getCount(entityManager);
    }
}
