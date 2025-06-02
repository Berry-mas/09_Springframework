package com.ohgiraffers.associationmapping.section02.ontomany;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name="category_and_menu")
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

    /*
    * fetch type default는 LAZY로 필요한 시점에 별도로 로딩해 온다.(select 문이 별도로 동작)
    * 즉시 로딩이 필요한 경우에는 fetch type을 EAGER로 명시해주어야 join 되어 한번에 조회된다.
    * */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name="categoryCode")  // "FK"컬럼명 작성
    private List<Menu> menuList;

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
