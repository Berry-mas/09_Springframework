package com.ohgiraffers.entity.section02.embeddable.subsection01.single.table;


import lombok.*;

@Data   // equals, hashcode 내용 다 들어가 있음 => 똑같은 값이면 동일 객체로 받겠다는 뜻
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String address1;
    private String address2;
    private String zipCode;
}
