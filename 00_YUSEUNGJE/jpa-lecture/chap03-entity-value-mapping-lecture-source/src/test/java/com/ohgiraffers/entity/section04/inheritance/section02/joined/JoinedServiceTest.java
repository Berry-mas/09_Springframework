package com.ohgiraffers.entity.section04.inheritance.section02.joined;

import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JoinedServiceTest {

    @Autowired
    private JoinedService joinedService;

    private static Stream<Arguments> developerAndManager() {
        return Stream.of(
                Arguments.of(
                        "홍길동", "010-1234-1234", "Java",
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
        DeveloperAndManagerDTO dm =
                DeveloperAndManagerDTO.builder()
                        .dName(dName)
                        .dContact(dContact)
                        .dLang(dLang)
                        .mName(mName)
                        .mContact(mContact)
                        .mlevel(mLevel).build();
        // when
        // then
        Assertions.assertDoesNotThrow(
                () -> joinedService.registDeveloperAndManager(dm)
        );
    }

    @DisplayName("Developer/Manager 조회")
    @ParameterizedTest
    @MethodSource("developerAndManager")
    void selectDeveloperAndManager(
            String dName, String dContact, String dLang,
            String mName, String mContact, String mLevel
    ){
        // given
        DeveloperAndManagerDTO dm =
                DeveloperAndManagerDTO.builder()
                        .dName(dName)
                        .dContact(dContact)
                        .dLang(dLang)
                        .mName(mName)
                        .mContact(mContact)
                        .mlevel(mLevel).build();
        // when
        // then
        Assertions.assertDoesNotThrow(
                () -> joinedService.registDeveloperAndManager(dm)
        );
        String jpql = "select a from Employee0000 a";
        List<Employee> employees = joinedService.selectEmployeeAll(jpql);

        /*
         * List - allSatisfy(List의 모든 요소는 다음 단정문을 만족해야한다.)
         *          Employee - satisfiesAnyOf(Employee객체는 다음 하나는 만족해야한다.)
         *   Employee객체는 Developer타입이다.
         *   Employee객체는 Manager타입이다.
         * */
        assertThat(employees).allSatisfy(
                employee -> assertThat(employee).satisfiesAnyOf(
                        (_employee) -> assertThat(_employee).isInstanceOf(Developer.class),
                        (_employee) -> assertThat(_employee).isInstanceOf(Manager.class)
                )
        );
    }
}