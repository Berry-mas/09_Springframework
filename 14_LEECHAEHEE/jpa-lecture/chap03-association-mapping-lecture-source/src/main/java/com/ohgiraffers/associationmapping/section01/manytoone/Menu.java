package com.ohgiraffers.associationmapping.section01.manytoone;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="menu_and_category")
@Table(name="tbl_menu")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Menu {

    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;
    /*
    * 영속성 전이 : 특정 엔터티를 영속화(영속성 컨텍스트에서 관리)할 때 연관된 엔터티도
    * 함께 영속화 한다는 의미이다.
    * fetch type default는 EAGER로 되어 있으며 필요한 경우 LAZY로 명시해서 지연 로딩을 할 수 있다.
    * */
    @ManyToOne(cascade = CascadeType.PERSIST/*fetch = FetchType.LAZY*/)
    @JoinColumn(name="categoryCode") // "FK"에 해당하는 컬럼명
    private Category category;

    private String orderableStatus;


}
