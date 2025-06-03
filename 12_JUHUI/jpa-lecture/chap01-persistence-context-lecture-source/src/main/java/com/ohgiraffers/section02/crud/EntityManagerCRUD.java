package com.ohgiraffers.section02.crud;

import com.ohgiraffers.section01.entitymanager.EntityManagerGenerator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EntityManagerCRUD {

    private EntityManager entityManager;

    /* 1. 특정 메뉴 코드로 메뉴를 조회하는 기능 */
    public Menu findMenuByMenuCode(int menuCode){
        entityManager = EntityManagerGenerator.getInstance();
        return entityManager.find(Menu.class, menuCode);//select문 만들어진 것임.심지어 조건문까지 갖춰서
    }

    /* 2. 새로운 메뉴 저장하는 기능 */
    public Long saveAndReturnAllCount(Menu newMenu){
        entityManager = EntityManagerGenerator.getInstance();

        /* DML(insert, update, delete) -> 트랜잭션 필요 */
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin(); // 여기서부터 시작할 거라고 명시

        entityManager.persist(newMenu); // 담아서 실행시키는 부분

        transaction.commit();
        return getCount(entityManager);
    }

    private Long getCount(EntityManager entityManager){
        // JPQL
        return entityManager.createQuery("SELECT COUNT(*) FROM Section02Menu", long.class).getSingleResult();
    }

    /* 3. 메뉴 이름 수정 기능 */
    public Menu modifyMenuName(int menuCode, String newMenuName){
        entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        foundMenu.setMenuName(newMenuName);

        transaction.commit();
        return foundMenu;
    }

    /* 4. 특정 메뉴 코드로 메뉴 삭제하는 기능 */
    public long removeAndReturnAllCount(int menuCode){
        entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode); // foundMenu가 영속성 컨텍스트라

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(foundMenu); // 변경이 감지되면 삭제시킴.

        transaction.commit();
        return getCount(entityManager);
    }

}
