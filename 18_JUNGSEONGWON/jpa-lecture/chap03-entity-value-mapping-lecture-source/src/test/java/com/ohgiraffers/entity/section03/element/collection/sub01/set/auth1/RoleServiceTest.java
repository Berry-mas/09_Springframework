package com.ohgiraffers.entity.section03.element.collection.sub01.set.auth1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    private static Stream<Arguments> getRole1() {
        return Stream.of(
                Arguments.of(
                        "ROLE_ADMIN",
                        "관리자",
                        Set.of("/admin/members", "/admin/members/update/*")
                )
        );
    }

    @DisplayName("Role Entity 등록 - FetchType.LAZY")
    @ParameterizedTest
    @MethodSource("getRole1")
    void registRole1(String id, String name, Set<String> permissions) {

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
                        "ROLE_MANAGER",
                        "매니져",
                        Set.of("/manager/members", "/manager/stat")
                )
        );
    }

    @DisplayName("Role Entity 등록 - FetchType.EAGER")
    @ParameterizedTest
    @MethodSource("getRole2")
    void registRole2(String id, String name, Set<String> permissions) {

        // given
        RoleDTO roleDTO = RoleDTO.builder().id(id).name(name).permissions(permissions).build();
        // when
        // then
        Assertions.assertDoesNotThrow(
                () -> roleService.registRole(roleDTO)
        );
    }

    private static Stream<Arguments> modifyPermissions() {
        return Stream.of(
                Arguments.of(
                        "ROLE_MANAGER",
                        "매니져",
                        Set.of("/manager/members", "/manager/stat"),
                        Set.of("/manager/members", "/manager/products")
                )
        );
    }

    @DisplayName("Role Entity 수정")
    @ParameterizedTest
    @MethodSource("modifyPermissions")
    void modifyRole(String id, String name,Set<String> oldPermissions, Set<String> newPermissions) {
        // given
        RoleDTO roleDTO = RoleDTO.builder().id(id).name(name).permissions(oldPermissions).build();
        // when
        roleService.registRole(roleDTO);
        // then
        // permission은 일부 수정이 아니라 set객체 전체를 교체한다.
        Assertions.assertDoesNotThrow(
                () -> roleService.modifyRole(id, newPermissions)
        );

    }

}