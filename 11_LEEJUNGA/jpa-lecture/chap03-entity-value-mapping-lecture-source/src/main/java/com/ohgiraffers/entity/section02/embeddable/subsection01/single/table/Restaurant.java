package com.ohgiraffers.entity.section02.embeddable.subsection01.single.table;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.Year;

@Entity
@Table(name = "tbl_restaurant")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Restaurant {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="since")
    private Year since;  // 오픈년도

    @Column(name="grade")
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Embedded
    private Address address;

    @Column(name="created_at")
    @CreationTimestamp // insert 시각을 자동으로 주입
    private LocalDateTime createdAt;

    @Column(name= "updated_at")
    @UpdateTimestamp   // update시각을 자동으로 갱신
    private LocalDateTime updatedAt;

}
