package com.ohgiraffers.entity.section03.element.collection.sub02.list.question1;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name="Question")
@Table(name="tbl_question")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;  // 문제 텍스트

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "tbl_question_choice",
            joinColumns = @JoinColumn(name="question_id") // fk 컬럼명
    )
    @Column(name="text")  // String이 저장될 컬럼명
    @OrderColumn(name="idx")   // List의 인덱스를 저장할 컬럼명
    private List<String> choices;

    public void changeChoices(List<String> newChoice) {
        this.choices = newChoice;
    }

}
