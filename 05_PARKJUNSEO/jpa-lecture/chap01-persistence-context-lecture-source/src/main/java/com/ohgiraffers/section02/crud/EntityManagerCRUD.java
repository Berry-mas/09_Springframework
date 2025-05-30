package com.ohgiraffers.section02.crud;

import com.ohgiraffers.section01.entitymanager.EntityManagerGenerator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EntityManagerCRUD {

    private EntityManager entityManager;

    /* 1. 특정 메뉴 코드로 메뉴를 조회하는 기능 */
    public Menu findMenuByMenuCode (int menuCode) {
        entityManager = EntityManagerGenerator.getInstance();
        // find 메소드 : 조회 용도
        return entityManager.find(Menu.class, menuCode);
    }

    public Long saveAndReturnAllCount(Menu newMenu) {
        entityManager = EntityManagerGenerator.getInstance();

        /* DML (insert, update, delete) => 트랜잭션이 필요함 */
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(newMenu);

        transaction.commit();
        return getCount(entityManager);
    }

    private Long getCount(EntityManager entityManager) {
        // JPQL
        return entityManager.createQuery("SELECT COUNT(*) FROM Section02Menu", Long.class).getSingleResult();
        // 위 코드를 보면 테이블이 아니라 엔터티를 보고 쿼리문을 짜는 것을 확인할 수 있음
    }

    /* 3. 메뉴 이름 수정 기능 */
    public Menu modifyMenuName(int menuCode, String newMenuName) {
        entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);  // 조회 쿼리 발생

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        foundMenu.setMenuName(newMenuName); // update 쿼리 발생

        transaction.commit();
        return foundMenu;
    }

    /* 4. 특정 메뉴 코드로 메뉴 삭제하는 기능 */
    public long removeAndReturnAllCount(int menuCode) {
        entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.remove(entityManager.find(Menu.class, menuCode));

        transaction.commit();


        return getCount(entityManager);
    }
}
