package com.ohgiraffers.entity.section01.aggregate;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class Receiver {
    private String receiverName;
    private String receiverPhone;
    private String receiverMessage;
}
