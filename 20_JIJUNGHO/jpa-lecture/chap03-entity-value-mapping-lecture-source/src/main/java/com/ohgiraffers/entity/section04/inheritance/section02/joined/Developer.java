package com.ohgiraffers.entity.section04.inheritance.section02.joined;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="joinDeveloper")
@Table(name="tbl_dev")
@DiscriminatorValue("dev") // Developer타입 구분하는 값을 dev로 지정(기본값: Developer)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Developer extends Employee {

    private String lang;

    public Developer(Long id, String name, String contact, String lang) {
        super(id, name, contact);
        this.lang = lang;
    }
}
