package com.ohgiraffers.restapi.section02.responseentity;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

    private int no;
    private String id;
    private String pwd;
    private String name;

}
