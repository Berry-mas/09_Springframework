package com.ohgiraffers.entity.section02.embeddable.subsection03.attribute.override;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="address1", column = @Column(name = "home_addr1")),
            @AttributeOverride(name="address2", column = @Column(name = "home_addr2")),
            @AttributeOverride(name="zipCode", column = @Column(name = "home_zip_code"))
    })
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="address1", column = @Column(name = "work_addr1")),
            @AttributeOverride(name="address2", column = @Column(name = "work_addr2")),
            @AttributeOverride(name="zipCode", column = @Column(name = "work_zip_code"))
    })
    private Address workAddress;
}
