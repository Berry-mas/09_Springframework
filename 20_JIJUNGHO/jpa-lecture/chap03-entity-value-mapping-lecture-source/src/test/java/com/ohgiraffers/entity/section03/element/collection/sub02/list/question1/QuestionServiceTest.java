package com.ohgiraffers.entity.section03.element.collection.sub02.list.question1;

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
class QuestionServiceTest {

    @Autowired
    private QuestionService questionService;


    private static Stream<Arguments> getQuestion() {
        return Stream.of(
                Arguments.of(
                        "다음 중 SQL의 종류가 아닌 것을 고르세요.",
                        List.of("DQL", "DML", "DCL", "DHL")
                )
        );
    }

    @DisplayName("Question 등록")
    @ParameterizedTest
    @MethodSource("getQuestion")
    void registQuestion(String text, List<String> choies){
        // given
        QuestionDTO questionDTO = QuestionDTO.builder().text(text).choices(choies).build();
        // when
        // then
        Assertions.assertDoesNotThrow(
                () ->  questionService.registQuestion(questionDTO)
        );
    }

    private static Stream<Arguments> getColorQuestion() {
        return Stream.of(
                Arguments.of(
                        1L,
                        "신호등의 색깔이 아닌것은?",
                        List.of("초록색", "빨간색", "주황색", "자몽색"),
                        List.of("GREEN", "BULE", "RED", "YELLOW")
                )
        );
    }

    @DisplayName("Question 객체 가져와서 수정")
    @ParameterizedTest
    @MethodSource("getColorQuestion")
    void registColorQuestion(Long id, String text, List<String> choices, List<String> changeChoices){

        // given
        QuestionDTO questionDTO = QuestionDTO.builder().id(id).text(text).choices(choices).build();
        questionService.registQuestion(questionDTO);
        // when
        // then
        questionDTO.setChoices(changeChoices);
        Assertions.assertDoesNotThrow(
                () -> questionService.modifyQuestion(questionDTO)
        );
    }
}