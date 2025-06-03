package com.ohgiraffers.section03.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EntityLifeCycleTest {

    private EntityLifeCycle entityLifeCycle;

    @BeforeEach
    void init(){
        entityLifeCycle = new EntityLifeCycle();
    }

    @DisplayName("비영속 테스트")
    @ParameterizedTest
    @ValueSource (ints = {1,2})
    void testTransList(int menuCode){

        // when
        Menu foundMenu = entityLifeCycle.findMenuByMenuCode(menuCode);

        Menu newMenu = new Menu(
                foundMenu.getMenuCode(),
                foundMenu.getMenuName(),
                foundMenu.getMenuPrice(),
                foundMenu.getCategoryCode(),
                foundMenu.getOrderableStatus()
        );
        EntityManager entityManager = entityLifeCycle.getManagerInstance();
        // then
        assertTrue(entityManager.contains(foundMenu)); // 영속성 컨텍스트에서 관리되는 영속 상태
        assertFalse(entityManager.contains(newMenu)); // 영속성 컨텍스트에서 관리 되지 않는 비영속 상태
    }

    @DisplayName("다른 엔터티 매니저가 관리하는 엔터티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2})
    void testmanagerOtherEntityManager(int menuCode){

        // when
        Menu menu1 = entityLifeCycle.findMenuByMenuCode(menuCode);
        System.out.println("menu1 = " + menu1.hashCode());
        Menu menu2 = entityLifeCycle.findMenuByMenuCode(menuCode);
        System.out.println("menu2 = " + menu2.hashCode());
        // then
        assertNotEquals(menu1, menu2);

    }

    @DisplayName("같은 엔터디 매니저가 관리하는 엔터티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints={1,2})
    void testmanagedSameEntityManager(int menuCode){

        // when
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu menu1 = entityManager.find(Menu.class, menuCode);
        Menu menu2 = entityManager.find(Menu.class, menuCode);
        // then

        assertEquals(menu1, menu2);
    }

    @DisplayName("준영속화 detach 테스트")
    @ParameterizedTest
    @CsvSource({"11,1000","12,1000"})
    void testDetachedEntity(int menuCode, int menuPrice){
        //when
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin(); // 트랜젝션의 시작

        Menu foundMenu = entityManager.find(Menu.class,menuCode); // 영속성 상태
        // detach : 특정 엔터디만 준영속상태로 만들어준다. ( 관리하던 객체를 관리하지 않는 상태로 변경)
        entityManager.detach(foundMenu);
        foundMenu.setMenuPrice(menuPrice);
        entityManager.flush(); // flush : 영속성 컨텍스트의 상태를 DB로 내보낸다. 단 commit 하지 않았을 경우 rollback이 가능하다.
        //then
        assertNotEquals(menuPrice,entityManager.find(Menu.class,menuCode));
        entityTransaction.rollback();
    }
    @DisplayName("준영속화 detach 후 다시 영속화 테스트")
    @ParameterizedTest
    @CsvSource({"11,1000","12,1000"})
    void testDetachAndMerge(int menuCode, int menuPrice){

        // when
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        entityManager.detach(foundMenu); // 준 영속화
        System.out.println("foundMenu = " + foundMenu);
        foundMenu.setMenuPrice(menuPrice); // 아무런 반응이 일어나지 않는다.

        // merge : 파라미터로 넘어온 준영속 앤터티 객체의 식별자 값으로 1차 캐시에서 엔터티 객체를 조회
        // (없으면 DB에서 조회하여 1차 캐시에 저장한다.)
        //조회한 영속 엔터티 객체에 준영속 상태의 엔터티 객체의 값을 병합 한 뒤 영속 엔터티 객체를 반환한다.
        // 혹은 조회할 수 없는 데이터라면 새로 생성해서 반환한다.

        entityManager.merge(foundMenu);
        entityManager.flush(); // flush : 영속성 컨텍스트의 상태를 DB로 내보낸다. 단 commit 하지 않았을 경우 rollback이 가능하다.
        //then
        assertEquals(menuPrice,entityManager.find(Menu.class,menuCode));
        entityTransaction.rollback();
    }

    @DisplayName("detach 후 merge 한 데이터 update 테스트")
    @ParameterizedTest
    @CsvSource({"11,하얀 민트초코죽","12, 까만 딸기탕후루"})

    void testMergeUpdate(int menuCode, String menuName){
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);
        entityManager.detach(foundMenu); // 준 영속화 -> 정어리 빙수가 떨어져나간다.

        foundMenu.setMenuName(menuName); // 상태 값 변경완료 -> 상태변경변화는 없다. 정어리빙수에서 하얀 민트 초코죽으로 바뀐다.

        Menu refoundMenu = entityManager.find(Menu.class, menuCode); // 영속 상태 정어리 빙수이며
        entityManager.merge(foundMenu); // merge를 하면 정어리빙수가 하얀 민트초코죽으로 병합된다.

        assertEquals(menuName,refoundMenu.getMenuName());
    }

    @DisplayName("detach 후 merge 한 데이터 save 테스트")
    @Test
    void testMergeSave(){
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Menu foundMenu = entityManager.find(Menu.class, 20);
        entityManager.detach(foundMenu); // 준 영속화

        entityTransaction.begin();
        foundMenu.setMenuName("치약맛 초코 아이스");
        foundMenu.setMenuCode(999);
        entityManager.persist(foundMenu);
        entityTransaction.commit(); // 기존에 값이 없기 때문에 insert문이 실행된다.
        assertEquals("치약맛 초코 아이스",entityManager.find(Menu.class,999).getMenuName());
        System.out.println("foundMenu = " + foundMenu);
    }

    @DisplayName("준 영속화 clear 테스트")
    @ParameterizedTest
    @ValueSource(ints ={1,3})
    void testClearPersistenceContext(int menuCode){
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        // clear : 영속성 컨텍스트를 초기화  -> 영속성 컨텍스트 내의 모든 엔터티는 준 영속화 된다.
        entityManager.clear();

        Menu expectedMenu = entityManager.find(Menu.class, menuCode);
        assertNotEquals(foundMenu,expectedMenu);
    }

    @DisplayName("준 영속화 close 테스트")
    @ParameterizedTest
    @ValueSource(ints ={1,3})
    void testClosePersistenceContext(int menuCode){
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode); // 영속화 발생

        // close : 영속성 컨텍스트를 종료한다. -> 영속성 컨텍스트 내의 모든 엔터니는 준 영속화 된다.
        entityManager.close();

        assertThrows(
                IllegalStateException.class,
                () -> entityManager.find(Menu.class, menuCode) // 영속성 컨텍스트가 없어 에러 발생
        );
    }

    @DisplayName("영속성 엔터티 삭제 remove 테스트")
    @ParameterizedTest
    @ValueSource(ints ={21})
    void testRemoveEntity(int menuCode){
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Menu foundMenu = entityManager.find(Menu.class, menuCode); // 영속화

        entityTransaction.begin();

        // remove : 엔터티를 영속성 컨텍스트 및 데이터베이스에서 삭제한다.
        // 단 , 트랙잭션을 제어하지 않으면 데이터에 영구 반영 되지는 않는다.
        entityManager.remove(foundMenu);
        entityManager.flush();
        System.out.println("foundMenu = " + foundMenu);

        Menu refoundMenu = entityManager.find(Menu.class, menuCode);

        assertNull(refoundMenu);

    }
}