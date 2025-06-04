package com.ohgiraffers.entity.section01.aggregate;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter(AccessLevel.PRIVATE) // 외부에서 값을 임의로 변경하는 것을 방지
@ToString
public class Order {

    private Long id;        // Order Entity의 식별자
    private Orderer orderer;
    private DeliveryInfo deliveryInfo;
    private List<OrderLine> orderLines; // 주문내역
    private int totalPrice;
    private OrderStatus orderStatus;
    private LocalDateTime orderDate;

    public Order(Long id, Orderer orderer, DeliveryInfo deliveryInfo, List<OrderLine> orderLines
            , int totalPrice, OrderStatus orderStatus, LocalDateTime orderDate) {
        this.id = id;
        this.orderer = orderer;
        this.deliveryInfo = deliveryInfo;
        this.setOrderLines(orderLines);
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
        // 총결제금액 계산
        this.totalPrice = orderLines.stream()
                .map((orderLine) -> orderLine.getPrice() * orderLine.getCount())
                .reduce(0, Integer::sum);
    }

    public void changeDeliveryAddress(Address newAddres){
        if(this.orderStatus == OrderStatus.주문확인중 || this.orderStatus == OrderStatus.배송준비중){
            this.deliveryInfo.changeAddress(newAddres);
        } else {
            throw new IllegalStateException("주문상품이 이미 발송되어서, 배송지정보를 수정할 수 없습니다.");
        }

    }
}
