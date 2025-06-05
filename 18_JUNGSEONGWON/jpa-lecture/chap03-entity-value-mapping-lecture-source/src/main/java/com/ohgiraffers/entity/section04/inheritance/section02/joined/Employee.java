package com.ohgiraffers.entity.section04.inheritance.section02.joined;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* super class */
@Entity(name="Employee0000")
@Table(name="tbl_employee_0000")
@Inheritance(strategy = InheritanceType.JOINED)
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
