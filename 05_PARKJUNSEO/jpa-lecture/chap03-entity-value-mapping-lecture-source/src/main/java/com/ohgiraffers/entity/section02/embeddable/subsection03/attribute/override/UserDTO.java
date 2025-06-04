package com.ohgiraffers.entity.section02.embeddable.subsection03.attribute.override;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class UserDTO {

    private String id;
    private String homeAddress1;
    private String homeAddress2;
    private String homeZipCode;
    private String workAddress1;
    private String workAddress2;
    private String workZipCode;
}
