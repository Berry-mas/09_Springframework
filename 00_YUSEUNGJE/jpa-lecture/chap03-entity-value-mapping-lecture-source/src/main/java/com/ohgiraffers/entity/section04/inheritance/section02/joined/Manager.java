package com.ohgiraffers.entity.section04.inheritance.section02.joined;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="joinedManager")
@Table(name="tbl_mana")
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
