package com.ohgiraffers.entity.section03.element.collection.sub01.set.auth2;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Permission {

    @Column(name="url", nullable = false)
    private String url;
    @Column(name="description", nullable = false)
    private String description;
}
