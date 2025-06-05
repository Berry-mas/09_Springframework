package com.ohgiraffers.entity.section04.inheritance.section03.table.per.clazz;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="Manager1112")
@Table(name="tbl_manager_1112")
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
