package com.ohgiraffers.entity.section04.inheritance.section01.single.table;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* super class */
@Entity
@Table(name="tbl_employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="emp_type") // sub class 타입을 결정하는 컬럼명
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String contact;
}
