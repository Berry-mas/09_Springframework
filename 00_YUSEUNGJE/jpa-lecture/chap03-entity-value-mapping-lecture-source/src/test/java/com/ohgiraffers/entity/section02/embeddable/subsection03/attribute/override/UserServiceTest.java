package com.ohgiraffers.entity.section02.embeddable.subsection03.attribute.override;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    private static Stream<Arguments> getUser() {
        return Stream.of(
                Arguments.of(
                      "honggd",
                        "집1", "집2", "00000",
                        "회사1", "회사2", "11111"
                )
        );
    }

    @DisplayName("User Entity 등록")
    @ParameterizedTest
    @MethodSource("getUser")
    void userInsert(
            String id,
            String homeAddress1, String homeAddress2, String homeZipCode,
            String workAddress1, String workAddress2, String workZipCode
    ){

        // given
        UserDTO userDTO = UserDTO.builder().id(id)
                .homeAddress1(homeAddress1)
                .homeAddress2(homeAddress2)
                .homeZipCode(homeZipCode)
                .workAddress1(workAddress1)
                .workAddress2(workAddress2)
                .workZipCode(workZipCode).build();
        // when
        // then
        Assertions.assertDoesNotThrow(
                () -> userService.registUser(userDTO)
        );
    }
}