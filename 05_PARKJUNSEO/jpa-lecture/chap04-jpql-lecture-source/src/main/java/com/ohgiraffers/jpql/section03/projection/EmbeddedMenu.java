package com.ohgiraffers.jpql.section03.projection;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tbl_menu")
public class EmbeddedMenu {

    @Id
    private int menuCode;

    @Embedded    //@Embeddable 타입을 사용하는 곳에 적용
    private MenuInfo menuInfo;

    private int categoryCode;
    private String orderableStatus;
}
