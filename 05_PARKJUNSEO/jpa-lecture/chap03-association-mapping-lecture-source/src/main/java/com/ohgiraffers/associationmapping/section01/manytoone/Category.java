package com.ohgiraffers.associationmapping.section01.manytoone;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "Section01Category")
@Table(name = "tbl_category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString   // 이렇게 어노테이션으로 엔티티 끝
public class Category {

    @Id
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;
}
