package com.ohgiraffers.entity.section02.embeddable.subsection01.single.table;


import lombok.*;

@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String address1;
    private String address2;
    private String zipCode;
}
