package com.ohgiraffers.restapi.section05.swagger;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
