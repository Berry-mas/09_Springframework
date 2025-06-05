package com.ohgiraffers.entity.section02.embeddable.subsection02.secondary.table;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class WriterDTO {

    private Long id;
    private String name;
    private String selfIntroduction;
    private String address1;
    private String address2;
    private String zipCode;
}
