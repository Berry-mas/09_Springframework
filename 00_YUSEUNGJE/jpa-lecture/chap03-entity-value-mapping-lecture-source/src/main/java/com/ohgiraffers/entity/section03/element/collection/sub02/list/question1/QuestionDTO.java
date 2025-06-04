package com.ohgiraffers.entity.section03.element.collection.sub02.list.question1;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class QuestionDTO {

    private Long id;
    private String text;
    private List<String> choices;
}
