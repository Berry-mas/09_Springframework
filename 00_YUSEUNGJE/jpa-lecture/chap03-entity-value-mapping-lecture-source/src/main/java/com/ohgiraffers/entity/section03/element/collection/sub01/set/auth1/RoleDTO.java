package com.ohgiraffers.entity.section03.element.collection.sub01.set.auth1;

import lombok.*;

import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class RoleDTO {

    private String id;
    private String name;
    Set<String> permissions;
}
