package com.ohgiraffers.entity.section03.element.collection.sub01.set.auth2;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class RoleDTO {

    private String id;
    private String name;
    private Set<Permission> permissions;
}
