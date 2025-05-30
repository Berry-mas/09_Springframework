package com.ohgiraffers.section03.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.annotations.Parameter;
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
    void init() {
        entityLifeCycle = new EntityLifeCycle();
    }

    @DisplayName("비영속 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 3})
        // given
    void testTransient(int menuCode) {

        // when
        // 얘는 영속 상태
        Menu foundMenu = entityLifeCycle.findMenuByMenuCode(menuCode);  // 영속성 컨텍스트에 포함될 것이라고 예상 (조회)

        // 비영속 상태
        Menu newMenu = new Menu(    // 영속성 컨텍스트에 있는 foundMenu로부터 가져와서 추가 (얘도 엔터티임)
                foundMenu.getMenuCode(),
                foundMenu.getMenuName(),
                foundMenu.getMenuPrice(),
                foundMenu.getCategoryCode(),
                foundMenu.getOrderableStatus()
        );

        EntityManager entityManager = entityLifeCycle.getManagerInstance();

        // then
        assertTrue(entityManager.contains(foundMenu));  // 영속성 컨텍스트에서 관리되는 영속 상태임을 확인
        assertFalse(entityManager.contains(newMenu));   // 영속성 컨텍스트에서 관리되지 않는 비영속 상태임을 확인
    }

    @DisplayName("다른 엔터티 매니저가 관리하는 엔터티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 3})
        // 총 4개의 쿼리문이 생성됨
    void testManagedOtherEntityManager(int menuCode) {

        // when
        Menu menu1 = entityLifeCycle.findMenuByMenuCode(menuCode);
        Menu menu2 = entityLifeCycle.findMenuByMenuCode(menuCode);

        // 둘이 주소값 다름
        System.out.println("menu1 = " + menu1.hashCode());
        System.out.println("menu2 = " + menu2.hashCode());

        // then
        assertNotEquals(menu1, menu2);
    }

    @DisplayName("같은 엔터티 매니저가 관리하는 엔터티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 3})
        // given
    void testManagedSameEntityManager(int menuCode) {

        // when
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu menu1 = entityManager.find(Menu.class, menuCode);  // 여기서 DB 다녀오고
        Menu menu2 = entityManager.find(Menu.class, menuCode);  // 이미 있는 쿼리문이므로 여기서는 영속성 컨텍스트에서 가져옴
        // 총 2개의 쿼리문이 생성됨 (같은 엔터티 매니저가 관리하는 엔터티들이기 때문임)
        // menu2는 menu2을 얕은 복사한 것이라고 볼 수 있음

        // then
        assertEquals(menu1, menu2);
    }

    @DisplayName("준영속화 detach 테스트")
    @ParameterizedTest
    @CsvSource({"11, 1000", "12, 1000"})
    void testDetachedEntity(int menuCode, int menuPrice) {

        // when
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();  // 트랜잭션 시작

        Menu foundMenu = entityManager.find(Menu.class, menuCode);   // 영속 상태

        // detach : 특정 엔터티만 준영속 상태(관리하던 객체를 관리하지 않는 상태로 변경)로 만듦
        entityManager.detach(foundMenu);    // 얘 때문에 foundMenu.setMenuPrice(menuPrice)를 해도 엔터티 업데이트 안됨
        foundMenu.setMenuPrice(menuPrice);

        // flush : 영속성 컨텍스트의 상태를 DB로 내보낸다. 단, commit 하지 않았을 경우 rollback 가능
        entityManager.flush(); // 현재 준영속 상태로, 관리되지 않고 있으므로 DB로 내보낼 menu가 없음

        // then      // 1000, 1000     // 실제 DB에서 가격 (10000, 2000)
        assertNotEquals(menuPrice,      entityManager.find(Menu.class, menuCode).getMenuPrice());
        entityTransaction.rollback();

    }

    @DisplayName("준영속화 detach 후 다시 영속화 테스트")
    @ParameterizedTest
    @CsvSource({"11, 1000", "12, 1000"})
    void testDetachAndMerge(int menuCode, int menuPrice) {

        // when
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();  // 트랜잭션 시작

        Menu foundMenu = entityManager.find(Menu.class, menuCode);   // 영속 상태
        entityManager.detach(foundMenu);    // 준영속화 => 준영속 상태
        foundMenu.setMenuPrice(menuPrice);  // 아무런 변화가 일어나지 않는다. (foundMenu가 관리되지 않는 준영속 상태이므로)
        // 정확히는, foundMenu는 바뀌었지만 그걸 엔터티가 관리하고 있지는 않음 (준영속 엔터티에 포함된다고 보면 됨)

        // merge : 파라미터로 넘어온 준영속 엔터티 객체의 식별자 값으로 1차 캐시에서 엔터티 객체를 조회한다.
        // (없으면 DB에서 조회하여 1차 캐시에 저장)
        // 조회한 영속 엔터티 객체에 준영속 상태의 엔터티 객체의 값을 병합한 뒤 영속 엔터티 객체를 반환한다.
        // 혹은 조회할 수 없는 데이터라면 새로 생성해서 반환한다.

        entityManager.merge(foundMenu); // 병합 => 영속상태로 다시 끌어들임 (이제 1000원인 상태에서 영속성 엔터티 매니저의 관리를 받음)
        entityManager.flush();  // 만약 병합하지 않고 flush 했다면 바뀐 가격이 DB에 반영되지 않았을 것임 (준영속 상태였을 것이므로)

        // then
        // 이제 둘 다 1000임
        assertEquals(menuPrice, entityManager.find(Menu.class, menuCode).getMenuPrice());
        entityTransaction.rollback();
    }

    @DisplayName("detach 후 merge한 데이터 update 테스트")
    @ParameterizedTest
    @CsvSource({"11, 하얀 초코", "12, 까만 딸기"})
    void testMergeUpdate(int menuCode, int menuName) {

        // when
        EntityManager entityManager = EntityManagerGenerator.getInstance();

        Menu foundMenu = entityManager.find(Menu.class, menuCode);   // 영속 상태 // 정어리빙수, 날치알스크류바
        entityManager.detach(foundMenu);    // 준영속화 => 준영속 상태

        foundMenu.setMenuPrice(menuName);   // 객체 상태값은 변화 but 준영속 상태   // 하얀 초코, 까만 딸기


        // 조회 쿼리문으로 메뉴코드 11, 12 찾아서 이름 바꾼 내용이 위에 있는데, 준영속 상태로 바뀌었으므로
        // 영속성 컨텍스트에 있지 않음 => 따라서 '조회 쿼리문 있어요?' 하면 없음. 따라서 DB에 다시 다녀옴
        // 즉 다시 쿼리문을 생성함
        Menu refoundMenu = entityManager.find(Menu.class, menuCode);    // 영속상태  // 정어리빙수, 날치알스크류바

        entityManager.merge(foundMenu); // 기준은 전달된 인자(foundMenud)임
        // 결과적으로 refoundMenu가 found에 의해 덮어쓰기 됨

        assertEquals(menuName, refoundMenu.getMenuName());
    }

    @DisplayName("detach 후 merge 한 데이터 save 테스트")
    @Test
    void testMergeSave() {
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Menu foundMenu = entityManager.find(Menu.class, 20);
        entityManager.detach(foundMenu);    // 준영속화

        entityTransaction.begin();
        foundMenu.setMenuName("치약맛 초코 아이스");
        foundMenu.setMenuCode(999); // foundMenu : 999, 치약맛 초코 아이스
        entityManager.merge(foundMenu); // 영속성 컨텍스트에 병합할 값이 없기 때문에 insert문이 실행됨
        entityTransaction.commit();
        // flush() : DB에 반영은 되지만 rollback 가능
        // commit() : DB에 반영되고 rollback 불가ㅣ능

        // then
        // 일단 메뉴 이름과 코드 모두 바뀐 걸 확인할 수 있음 (영속성 컨텍스트에서만)
        assertEquals("치약맛 초코 아이스", entityManager.find(Menu.class, 999).getMenuName());
    }

    @DisplayName("준영속화 clear 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    void testClearPersistenceContext(int menuCode) {
         EntityManager entityManager = EntityManagerGenerator.getInstance();
         Menu foundMenu = entityManager.find(Menu.class, menuCode);

         // clear : 영속성 컨텍스트를 초기화한다 => 영속성 컨텍스트 내의 모든 엔터티는 준영속화 된다. (빼냄)
         entityManager.clear();

        System.out.println("====> " + entityManager.contains(foundMenu));  // 아무것도 없음

         // foundMenu는 아무것도 없음 (초기화 했으므로)

         // expectedMenu는 메뉴코드 1, 3을 찾는 쿼리문을 새로 생성하게 됨 => foundMenu와 주소값 다름
         Menu expectedMenu = entityManager.find(Menu.class, menuCode);

        // foundMenu와 expectedMenu는 내용은 같지만 주소는 다른 상태가 됨
         assertNotEquals(foundMenu, expectedMenu);
    }

    @DisplayName("준영속화 close 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    void testClosePersistenceContext(int menuCode) {
        // close : 영속성 컨텍스트 자체를 종료한다 => 영속성 컨텍스트 내의 모든 엔터티는 준영속화 된다.

        EntityManager entityManager = EntityManagerGenerator.getInstance();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);  // 영속화  // select 쿼리문 2개 생성

        entityManager.close();  // 메뉴코드 1, 3인 두 엔터티는 준영속화 되고 영속성 컨텍스트는 종료됨

        assertThrows(
                IllegalStateException.class,
                () -> entityManager.find(Menu.class, menuCode)
        );
        // 준영속화 된 엔터티들을 사용하고 싶다면 다시 영속성 컨텍스트를 만들어서 병합해줘야 함
    }

    @DisplayName("영속성 엔터티 삭제 remove 테스트")
    @ParameterizedTest
    @ValueSource(ints ={42})
    void testRomoveEntity(int menuCode) {
        EntityManager entityManager = EntityManagerGenerator.getInstance();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Menu foundMenu = entityManager.find(Menu.class, menuCode);  // 영속화

        entityTransaction.begin();  // 트랜잭션 시작

        // remove: 엔터티를 영속성 컨텍스트 및 데이터베이스에서 삭제한다.
        // 단, 트랜잭션을 제어하지 않으면 데이터베이스에 영구 반영되지는 않는다.
        entityManager.remove(foundMenu);

        entityManager.flush();  // DB로 내보내기 (반영)
        // entityTransaction.rollback();

        Menu refoundMenu = entityManager.find(Menu.class, menuCode);    // DB에 반영했기 때문에 같은 메뉴코드를 가진 항목을 찾아도 없음
        assertNull(refoundMenu);    // 이미 remove 처리된 메뉴코드에 대해 select를 했기 떄문에 null값 처리함
        // 만약 flush 이후 곧바로 rollback 했으면 refoundMenu은 null이 안됨
        entityTransaction.rollback();


    }


}