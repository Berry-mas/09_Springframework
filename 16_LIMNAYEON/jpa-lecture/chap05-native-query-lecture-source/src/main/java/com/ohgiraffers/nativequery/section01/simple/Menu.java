package com.ohgiraffers.nativequery.section01.simple;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.Id;


@Entity(name="Section01Menu")
@Table(name="tbl_menu")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Menu {

    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;
}
