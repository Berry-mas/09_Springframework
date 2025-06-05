package com.ohgiraffers.entity.section01.aggregate;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@Setter(AccessLevel.PRIVATE)
public class Address implements Serializable {

    private String address1;  // 일반주소
    private String address2;  // 상세주소
    private String zipCode;   // 우편번호
}
