package com.ohgiraffers.entity.section03.element.collection.sub03.map.setting2;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class PropValue {

    @Column(name="value", nullable=false)
    private String value;

    @Column(name="enabled")
    private boolean enabled;
}
