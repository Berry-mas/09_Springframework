package com.ohgiraffers.entity.section03.element.collection.sub02.list.question2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuestionTwoServiceTest {

    @Autowired
    private QuestionTwoService questionTwoService;

    private static Stream<Arguments> getQuestion() {
        return Stream.of(
                Arguments.of(
                        "다음 중 과일과 색깔이 잘 매칭된 것을 고르세요.",
                        List.of(
                                new Choice("사과", "검정색"),
                                new Choice("바나나", "파란색"),
                                new Choice("토마토", "토마토색"),
                                new Choice("딸기", "아이보리색")
                        )
                )
        );
    }

    @DisplayName("Question 등록")
    @ParameterizedTest
    @MethodSource("getQuestion")
    void registQuestion(String text, List<Choice> choices) {

        // given
        QuestionDTO questionDTO = QuestionDTO.builder()
                .text(text)
                .choices(choices).build();
        // when
        // then
        Assertions.assertDoesNotThrow(
                () -> questionTwoService.registQuestion(questionDTO)
        );
    }

    private static Stream<Arguments> getMenuQuestion() {
        return Stream.of(
                Arguments.of(
                        1L,
                        "음식점과 메뉴의 조합이 올바른 것은?",
                        List.of(
                                new Choice("맥도날드", "와퍼"),
                                new Choice("스타벅스", "아이스누릉지죽"),
                                new Choice("버거킹", "와퍼"),
                                new Choice("박서방순대국", "인디안커리")
                        ), List.of(
                                new Choice("스타벅스", "아이스누릉지죽"),
                                new Choice("맥도날드", "와퍼"),
                                new Choice("버거킹", "와퍼"),
                                new Choice("박서방순대국", "인디안커리")
                        )
                )
        );
    }

    @DisplayName("Question 객체 가져와서 수정하기")
    @ParameterizedTest
    @MethodSource("getMenuQuestion")
    void modifyQuestion(Long id, String text, List<Choice> oldChoices, List<Choice> newChoices) {

        // given
        QuestionDTO questionDTO = QuestionDTO.builder()
                .text(text)
                .choices(oldChoices).build();
        questionTwoService.registQuestion(questionDTO);
        // when
        // then
        questionDTO.setId(id);
        questionDTO.setChoices(newChoices);

        Assertions.assertDoesNotThrow(
                () -> questionTwoService.modifyQuestion(questionDTO)
        );
    }

}