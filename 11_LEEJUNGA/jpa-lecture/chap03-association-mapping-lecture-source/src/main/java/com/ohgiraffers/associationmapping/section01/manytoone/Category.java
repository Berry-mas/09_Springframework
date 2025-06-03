package com.ohgiraffers.associationmapping.section01.manytoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="Section01Category")
@Table(name="tbl_category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Category {
    @Id
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

}
