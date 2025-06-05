package com.ohgiraffers.entity.section03.element.collection.sub01.set.auth2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;
import java.util.stream.Stream;

@SpringBootTest
class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    private static Stream<Arguments> getRole1() {
        return Stream.of(
                Arguments.of(
                        "ROLE_ADMIN",
                        "관리자",
                        Set.of(
                                new Permission("/admin/members", "관리자용 회원관리"),
                                new Permission("/admin/roles", "관리자용 권한관리")
                        )
                )
        );
    }

    @DisplayName("Role Entity 등록")
    @ParameterizedTest
    @MethodSource("getRole1")
    void registRole1(
            String id, String name, Set<Permission> permissions
    ){
        // given
        RoleDTO roleDTO = RoleDTO.builder().id(id).name(name).permissions(permissions).build();
        // when
        // then
        Assertions.assertDoesNotThrow(
                () -> roleService.registRole(roleDTO)
        );
    }

    private static Stream<Arguments> getRole2() {
        return Stream.of(
                Arguments.of(
                        "ROLE_ADMIN",
                        "관리자",
                        Set.of(
                                new Permission("/admin/members", "관리자용 회원관리"),
                                new Permission("/admin/roles", "관리자용 권한관리")
                        ),
                        Set.of(new Permission("/admin/members", "관리자용 회원관리"))
                )
        );
    }

    @DisplayName("Role Entity의 permissions 수정")
    @ParameterizedTest
    @MethodSource("getRole2")
    void modifyRole(
            String id, String name, Set<Permission> oldPermissions, Set<Permission> newPermissions
    ){

        // given
        RoleDTO roleDTO = RoleDTO.builder().id(id).name(name).permissions(oldPermissions).build();

        roleService.registRole(roleDTO);
        // when
        // then
        roleDTO.setPermissions(newPermissions);
        Assertions.assertDoesNotThrow(
                () -> roleService.modifyRole(roleDTO)
        );
    }
}