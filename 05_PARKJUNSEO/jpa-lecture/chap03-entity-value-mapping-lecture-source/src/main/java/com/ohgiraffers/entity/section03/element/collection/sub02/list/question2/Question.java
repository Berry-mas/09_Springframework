package com.ohgiraffers.entity.section03.element.collection.sub02.list.question2;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity(name="Question5555")
@Table(name="tbl_question_5555")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name="tbl_question_choice_55551",
            joinColumns = @JoinColumn(name="question_id")
    )
    @OrderColumn(name="idx")
    private List<Choice> choices;

    public void changeChoices(List<Choice> newChoices) {
        this.choices = newChoices;
    }
}
