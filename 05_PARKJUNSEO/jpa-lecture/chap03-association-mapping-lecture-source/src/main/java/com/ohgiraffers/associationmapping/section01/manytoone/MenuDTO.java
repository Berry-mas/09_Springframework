package com.ohgiraffers.associationmapping.section01.manytoone;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class MenuDTO {

    private int menuCode;
    private String menuName;
    private int price;
    private CategoryDTO category;
    private String orderableStatus;

}
