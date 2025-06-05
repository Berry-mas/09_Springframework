package com.ohgiraffers.entity.section04.inheritance.section01.single.table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@DiscriminatorValue("manager") // Manager 타입 구분하는 값을 manager로 지정(기본값: Manager)
@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Manager extends Employee {

    private String level;

    public Manager(Long id, String name, String contact, String level) {
        super(id, name, contact);
        this.level = level;
    }

}
