package com.ohgiraffers.datajpa.menu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_category")
@Getter
/* 🚨 Setter는 지양하는 것이 좋음
 * : 객체를 언제든지 변경할 수 있는 상태가 되므로 객체의 안정성이 보장 되지 않을 수 있다.
 *   단, 값 변경이 필요한 경우에는 해당 비즈니스 로직에 맞는 명확한 목적의 기능 메소드를 정의한다.
 * */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
/* 기본 생성자가 필요하지만 접근 제한을 걸어 외부에서 무분별하게 엔터티 객체를 생성하는 것을 지양한다.
 * @AllArgsConstructor 지양 : 인스턴스 선언 순서에 영향을 받으므로 변수 순서 변경 시
 * 입력 값 순서도 바뀌므로 검출하기 힘든 오류 발생 가능성이 있다. */
/* @ToString : 사용 시 연관 관계 매핑 필드는 제거한다. */
public class Category {

    @Id
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

}
