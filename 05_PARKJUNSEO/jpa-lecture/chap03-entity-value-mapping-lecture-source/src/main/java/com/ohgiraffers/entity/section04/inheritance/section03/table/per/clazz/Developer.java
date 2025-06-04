package com.ohgiraffers.entity.section04.inheritance.section03.table.per.clazz;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="Developer1112")
@Table(name="tbl_dev_1112")
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
