package com.ohgiraffers.entity.section03.element.collection.sub02.list.question2;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Choice {

    @Column(name="a")
    private String a;

    @Column(name="b")
    private String b;
}
