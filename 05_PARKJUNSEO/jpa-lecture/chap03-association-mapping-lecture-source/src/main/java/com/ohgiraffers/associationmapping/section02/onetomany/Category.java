package com.ohgiraffers.associationmapping.section02.onetomany;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity(name = "category_and_menu")
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

    /*
    * fetch type defaultt는 LAZY로 필요한 시점에 별도로 로딩해온다.
    * (select문이 별도로 동작)
    * 즉시 로딩이 필요한 경우엔은 fetch type을 EAGER로 명시해주어야 join 되어 한번에 조회된다.
    * */
    @OneToMany
    @JoinColumn(name = "categoryCode")  // "FK" 컬럼명 작성
    private List<Menu> menuList;
}
