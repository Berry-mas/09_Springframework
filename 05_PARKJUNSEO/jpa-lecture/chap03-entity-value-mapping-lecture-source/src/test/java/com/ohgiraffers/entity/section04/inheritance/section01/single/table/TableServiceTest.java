package com.ohgiraffers.entity.section04.inheritance.section01.single.table;

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
class TableServiceTest {

    @Autowired
    private TableService tableService;

    private static Stream<Arguments> developerAndManager() {
        return Stream.of(
                Arguments.of(
                        "홍길동","010-1234-1234", "Java",
                        "신사임당", "010-6543-6543", "M3"
                )
        );
    }

    @DisplayName("Developer/Manager Entity 등록")
    @ParameterizedTest
    @MethodSource("developerAndManager")
    void registDeveloperAndManager(
            String dName, String dContact, String dLang,
            String mName, String mContact, String mLevel
    ){
        // given
        DeveloperAndManagerDTO dm = DeveloperAndManagerDTO.builder()
                .dName(dName).dContact(dContact).dLang(dLang)
                .mName(mName).mContact(mContact).mlevel(mLevel).build();
        // when
        // then
        Assertions.assertDoesNotThrow(
                () -> tableService.registDeveloperAndManager(dm)
        );
    }
}