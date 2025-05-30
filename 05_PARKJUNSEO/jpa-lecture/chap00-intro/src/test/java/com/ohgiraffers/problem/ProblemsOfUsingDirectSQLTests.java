package com.ohgiraffers.problem;

import org.junit.jupiter.api.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProblemsOfUsingDirectSQLTests {

    private Connection con;

    @BeforeEach
    void setConnection() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/menudb";
        String user = "ohgiraffers";
        String password = "ohgiraffers";

        Class.forName(driver);

        con = DriverManager.getConnection(url, user, password);
        con.setAutoCommit(false);   // 수동 커밋 등록
    }

    @AfterEach
    void CloseConnection() throws SQLException {
        con.rollback();
        con.close();
    }

    /*
    * [ JDBC API를 이용해 직접 SQL을 다룰 때 발생할 수 있는 문제점 ]
    * 1. 데이터 변환, SQL 작성, JDBC API 코드 등을 중복 작성 (= 개발 시간 증가, 유지보수성 악화)
    * 2. SQL 의존적 개발
    * 3. 패러다임 불일치 문제 (상속, 연관관계, 객체 그래프 탐색)
    * 4. 동일성 보장 문제
    * */

    // 1. 데이터 변환, SQL 작성, JDBC API 코드 등을 중복 작성 (= 개발 시간 증가, 유지보수성 악화)
    @Test
    @DisplayName("직접 SQL을 작성하여 메뉴를 조회할 때 발생하는 문제 확인")
//  답 : 🚨 내가 직접 쿼리문을 작성했기 때문에 DB가 바뀌면 다 직접 일일이 수정해야함 🚨
    void testDirectSelectSQL() throws SQLException {

        // given
        String query = "SELECT menu_code, menu_name, menu_price, category_code, orderable_status FROM tbl_menu";

        // when
        Statement stmt = con.createStatement();
        ResultSet rset = stmt.executeQuery(query);

        List<Menu> menuList = new ArrayList<>();
        while(rset.next()) {
            Menu menu = new Menu();
            menu.setMenuCode(rset.getInt("menu_code"));
            menu.setMenuName(rset.getString("menu_name"));
            menu.setMenuPrice(rset.getInt("menu_price"));
            menu.setCategoryCode(rset.getInt("category_code"));
            menu.setOrderableStatus(rset.getString("orderable_status"));

            menuList.add(menu);
        }


        // then
        Assertions.assertNotNull(menuList);

        rset.close();
        stmt.close();
    }

    @Test
    @DisplayName("직접 SQL을 작성하여 신규 메뉴 추가 시 발생하는 문제 확인")
//  답 : 🚨 내가 직접 쿼리문을 작성했기 때문에 DB가 바뀌면 다 직접 일일이 수정해야함 🚨
    void testDirectInsertSQL() throws SQLException {

        // given
        Menu menu = new Menu();
        menu.setMenuName("진라면볶음밥");
        menu.setMenuPrice(20000);
        menu.setCategoryCode(1);
        menu.setOrderableStatus("Y");

        String query = "INSERT INTO tbl_menu(menu_name, menu_price, category_code, orderable_status) VALUES (?, ?, ?, ?)";

        // when
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, menu.getMenuName());
        pstmt.setDouble(2, menu.getMenuPrice());
        pstmt.setInt(3, menu.getCategoryCode());
        pstmt.setString(4, menu.getOrderableStatus());

        int result = pstmt.executeUpdate();

        // then
        Assertions.assertEquals(1, result);
        pstmt.close();
    }

    /* 조회 항목 변경에 따른 의존성 */
    @Test
    @DisplayName("조회 항목 변경에 따른 의존성")
    void testDirectSelectColumnSQL() throws SQLException {

        // given
        String query = "SELECT menu_code, menu_name, menu_price, category_code FROM tbl_menu";

        // when
        Statement stmt = con.createStatement();
        ResultSet rset = stmt.executeQuery(query);

        List<Menu> menuList = new ArrayList<>();
        while(rset.next()) {
            Menu menu = new Menu();
            menu.setMenuCode(rset.getInt("menu_code"));
            menu.setMenuName(rset.getString("menu_name"));
            menu.setMenuPrice(rset.getInt("menu_price"));
            menu.setCategoryCode(rset.getInt("category_code"));
            // orderable_status 열이 없어졌다고 가정 => 코드 싹 다 바꿔야 함

            menuList.add(menu);
        }


        // then
        Assertions.assertNotNull(menuList);

        rset.close();
        stmt.close();
    }


    // 패러다임 : 객체 != SQL (data)
    /* 3. 패러다임 불일치 (상속, 연관관계, 객체 그래프 탐색) */

    /* 3-1. 상속 문제 */
    /*
     * 객체 지향 언어의 상속 개념과 유사한 것이 데이터베이스의 서브타입엔티티 이다.
     * 유사한 것 같지만 다른 부분은 데이터베이스의 상속은 상속 개념을 데이터로 추상화해서 슈퍼타입과 서브타입으로 구분하고,
     * 슈퍼타입의 모든 속성을 서브타입이 공유하지 못하여 물리적으로 다른 테이블로 분리가 된 형태이다.
     * (설계에 따라서는 속성으로 추가되기도 한다.)
     * 하지만 객체지향의 상속은 슈퍼타입의 속성을 공유해서 사용하므로 여기서 패러다임 불일치 현상이 발생한다.
     *
     * 법인 회원과 일반 회원이라는 두 가지 회원을 추상화하여 회원이라는 슈퍼타입 엔터티를 도출하고
     * 서브타입 엔터티로 법인회원과 일반회원이 존재하는 상황인 경우
     * 물리적으로 회원과 법인회원 테이블로 분리된 상황에서는 각각 insert 구문을 수행해야 한다.
     * INSERT INTO 회원 ...
     * INSERT INTO 법인회원 ...
     * 하지만 JPA를 이용하여 상속을 구현한 경우에는
     * entityManager.persist(법인회원);
     * 이렇게 한 번에 해결이 가능하다.
     * */

    /* 3-2. 연관관계 문제, 객체 그래프 탐색 문제 */
    /*
     * < 데이터베이스 테이블에 맞춘 객체 모델 >
     * 객체지향에서 말하는 가지고 있는(association 연관관계, 혹은 collection 연관관계) 경우 데이터베이스 저장 구조와 다른 형태이다.
     *   public class Menu {
     *     private int menuCode;
     *     private String menuName;
     *     private int menuPrice;
     *     private int categoryCode; (FK)
     *     private String orderableStatus;
     *   }
     *   public class Category {
     *     private int categoryCode;
     *     private String categoryName;
     *   }
     *
     * < 객체지향 언어에 맞춘 객체 모델 >
     *   public class Menu {
     *     private int menuCode;
     *     private String menuName;
     *     private int menuPrice;
     *     private Category categoryCode;
     *     private String orderableStatus;
     *   }
     *   public class Category {
     *     private int categoryCode;
     *     private String categoryName;
     *   }
     * */

    @Test
    @DisplayName("연관된 객체 문제 확인")
    void testAssociationObject() throws SQLException {

        // given
        String query = "SELECT a.menu_code, a.menu_name, a.menu_price, " +
                "b.category_code, b.category_name, a.orderable_status " +
                "FROM tbl_menu a JOIN tbl_category b ON a.category_code = b.category_code";

        // when
        Statement stmt = con.createStatement();
        ResultSet rset = stmt.executeQuery(query);

        // then
        List<MenuAndCategory> menuAndCategories = new ArrayList<>();
        while (rset.next()) {
            MenuAndCategory menuAndCategory = new MenuAndCategory();
            menuAndCategory.setMenuCode(rset.getInt("menu_code"));
            menuAndCategory.setMenuName(rset.getString("menu_name"));
            menuAndCategory.setMenuPrice(rset.getInt("menu_price"));

            Category category = new Category(
                    rset.getInt("category_code"),
                    rset.getString("category_name")
            );
            menuAndCategory.setCategory(category);
            menuAndCategory.setOrderableStatus(rset.getString("orderable_status"));

            menuAndCategories.add(menuAndCategory);
        }

        // 검증: 리스트가 비어있지 않음을 확인
        Assertions.assertFalse(menuAndCategories.isEmpty(), "결과 리스트가 비어 있지 않아야 합니다.");

        // 자원 정리
        rset.close();
        stmt.close();
    }


    /* 4. 동일성 보장 문제 */
    void testEquals() throws SQLException {

        // given
        String query = "SELECT menu_code, menu_name FROM tbl_menu WHERE menu_code=1";

        // when
        Statement stmt1 = con.createStatement();
        ResultSet rset1 = stmt1.executeQuery(query);

        Menu menu1 = null;
        while (rset1.next()) {
            menu1 = new Menu();
            menu1.setMenuCode(rset1.getInt("menu_code"));
            menu1.setMenuName(rset1.getString("menu_name"));
        }

        Statement stmt2 = con.createStatement();
        ResultSet rset2 = stmt1.executeQuery(query);

        Menu menu2 = null;
        while (rset1.next()) {
            menu1 = new Menu();
            menu1.setMenuCode(rset2.getInt("menu_code"));
            menu1.setMenuName(rset2.getString("menu_name"));
        }

        // then
        Assertions.assertFalse(menu1 == menu2); // 동일성 x
        Assertions.assertTrue(menu1.getMenuName() == menu2.getMenuName());  // 동등성 o

        rset1.close();
        stmt1.close();
        rset2.close();
        stmt2.close();
    }

}