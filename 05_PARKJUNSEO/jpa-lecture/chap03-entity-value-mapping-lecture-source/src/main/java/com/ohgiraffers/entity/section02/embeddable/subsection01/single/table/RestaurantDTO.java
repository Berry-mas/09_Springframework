package com.ohgiraffers.entity.section02.embeddable.subsection01.single.table;

import lombok.*;

import java.time.LocalDateTime;
import java.time.Year;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RestaurantDTO {

    private String id;
    private String name;
    private Year since;  // 오픈년도
    private Grade grade;
    private Address address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
