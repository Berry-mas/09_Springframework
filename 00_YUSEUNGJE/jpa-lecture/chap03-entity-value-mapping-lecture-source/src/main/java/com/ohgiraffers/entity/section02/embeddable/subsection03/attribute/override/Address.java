package com.ohgiraffers.entity.section02.embeddable.subsection03.attribute.override;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Column(name="addr1")
    private String address1;

    @Column(name="addr2")
    private String address2;

    @Column(name="zip_code")
    private String zipCode;
}
