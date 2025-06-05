package com.ohgiraffers.entity.section01.aggregate;

import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class DeliveryInfo {

    // 수신자 정보
    private Receiver receiver;
    // 주소관련 정보
    private Address address;

    public void changeAddress(Address address) { // 수정 메소드
        this.address = address;
    }
}
