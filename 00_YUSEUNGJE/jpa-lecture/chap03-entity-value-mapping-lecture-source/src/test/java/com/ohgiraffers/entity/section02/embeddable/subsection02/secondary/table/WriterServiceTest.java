package com.ohgiraffers.entity.section02.embeddable.subsection02.secondary.table;

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
class WriterServiceTest {

    @Autowired
    private WriterService writerService;

    private static Stream<Arguments> getWriter() {
        return Stream.of(
                Arguments.of(
                        "이순신",
                        "안녕하세요 이순신입니다. 제가 거북선이라는 노래를 하나 발매했어요.",
                        "전남 여수시",
                        "거북마을 1234번지",
                        "1234"
                )
        );
    }

    @DisplayName("Writer Entity 등록")
    @ParameterizedTest
    @MethodSource("getWriter")
    void writerInsert(
            String name, String selfIntroduction, String address1, String address2, String zipCode
    ){

        // given
        WriterDTO writerDTO = WriterDTO.builder()
                                    .name(name)
                                    .selfIntroduction(selfIntroduction)
                                    .address1(address1)
                                    .address2(address2)
                                    .zipCode(zipCode).build();
        // when
        // then
        Assertions.assertDoesNotThrow(
                () -> writerService.registWriter(writerDTO)
        );
    }
}