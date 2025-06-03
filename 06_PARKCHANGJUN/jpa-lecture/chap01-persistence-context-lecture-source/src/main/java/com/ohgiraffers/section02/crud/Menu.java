package com.ohgiraffers.section02.crud;

import jakarta.persistence.*;

// 기본 이름은 클래스며이며 중복되면 안된다.
// 다음과 같이 입력하면 menu라는 테이블명을 만들 수 있다.
@Entity(name="Section02Menu")
@Table(name="tbl_menu")
public class Menu {

    @Id
    @Column(name="menu_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;

    @Column(name="menu_name")
    private String menuName;

    @Column(name="menu_price")
    private int menuPrice;

    @Column(name="category_code")
    private int categoryCode;

    @Column(name="orderable_status")
    private String orderableStatus;

    public Menu() {
    }

    public Menu(String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
