package com.ohgiraffers.entity.section01.aggregate;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class Orderer {
    private Long ordererId; //주문한 회원정보 -> 에그리게이트 경계가 있으므로 직접 회원을 참조하지 않는다.
    private String ordererName;
}
