package com.ohgiraffers.entity.section04.inheritance.section01.single.table;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class DeveloperAndManagerDTO {

    private Long id;
    private String dName;
    private String dContact;
    private String dLang;
    private String mName;
    private String mContact;
    private String mlevel;
}
