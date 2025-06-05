package com.ohgiraffers.entity.section01.aggregate;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class OrderLine {

    private Long productId;    // 상품객체를 직접참조x , 실제 pk값만 참조
    private int count;
    private int price;
}
