package com.ohgiraffers.section02.crud;

import jakarta.persistence.*;

import javax.naming.Name;

// Entity 클래스 (DB에 변화가 생기면 Entity 클래스만 수정하면 됨 -> JPA가 알아서 쿼리문을 수정함)
// 기본 이름은 클래스명이며, 중복되면 안된다.
@Entity(name="Section02Menu")
@Table(name= "tbl_menu")
public class Menu {

    @Id // pk에 대한 내용을 설정
    @Column(name = "menu_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성 방식
    private int menuCode;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_price")
    public int menuPrice;

    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "orderable_status")
    private String orderableStatus;

    public Menu() {}

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


