package com.ohgiraffers.entity.section01.aggregate;

import java.time.LocalDateTime;
import java.util.List;

public class Application {
    /*
    * 1. 에그리게이트(Aggregate)
    *
    * 경계(Boundary): 애그리게이트는 관련된 엔티티와 밸류 오브젝트를 하나의 논리적인 단위로 묶은 것이다. 이는 시스템에서 일관성을 유지해야 할 경계로 간주된다.
    * 루트 엔티티(Root Entity): 애그리게이트는 항상 하나의 루트 엔티티를 가진다. 외부에서는 루트 엔티티를 통해서만 애그리게이트 내부에 접근할 수 있다.
    * 일관성 유지: 애그리게이트 내의 모든 변경은 일관성을 유지하며 일어나야 한다. 이를 위해 트랜잭션 단위로 처리된다.
    *
    * 2. 엔티티(Entity)
     * - 식별자(Identifier): 엔티티는 고유한 식별자를 가진다. 이 식별자를 통해 엔티티를 식별하고 구분할 수 있다.
     * - 상태와 행동: 엔티티는 상태(state)와 행동(behavior)을 가진다. 상태는 엔티티의 속성을 나타내고, 행동은 엔티티가 수행할 수 있는 동작을 의미한다.
     * - 변경 가능성: 엔티티의 상태는 시간에 따라 변경될 수 있다.
     * - 예시 > 사용자(User) 엔티티 : 아이디, 비밀번호, 이름, 성별, 생년월일, 주소.....속성을 가지고있다. 사용자 정보를 변경하는 행동을 포함할 수 있다.
     *
     * 3.  밸류 오브젝트(Value Object)
     * - 식별자 없음: 밸류 오브젝트는 고유한 식별자를 가지지 않는다. 그 대신 속성의 값 자체가 객체를 정의한다.
     * - 불변성(Immutability): 밸류 오브젝트는 생성된 이후에 상태가 변경되지 않는다. 상태 변경이 필요할 경우 새로운 밸류 오브젝트를 생성한다.
     * - 동등성(Equality): 밸류 오브젝트는 속성의 값이 동일하다면 같은 객체로 간주된다.
     * - 예시 > 주소(address) : 거리, 도시, 우편번호 등의 속성을 포함
    * */
    public static void main(String[] args) {
        /*
        * 주문 애그리게이트:
        *   주문은 주문(Order)루트 엔티티, 주문상품(OrderLine) 벨류 오브젝트, 주문자(Orderer) 벨류 오브젝트,
        *   배송정보(DeliveryInfo) 벨류 오브젝트 등을 포함, 주문은 애그리게이트의 루트 엔티티가 된다.
        *
        * 주문내역은 주문 루트엔티티를 통해서만 주문정보 조회나 배송정보를 변경할 수 있다.
        * */
        // 주문을 생성하라
        // 결제금액을 계산하라
        Order order = new Order(
                1L,
                new Orderer(100L, "홍길동"),
                new DeliveryInfo(
                        new Receiver("신사임당", "010-1234-1234", "🚀🚀🚀로켓배송 부탁드립니다."),
                        new Address("서울시 서초구 ", "방배동 12345", "01234")
                ),
                List.of(new OrderLine(1L, 3, 30000), new OrderLine(2L, 2, 5000)),
                0,
                OrderStatus.주문확인중,
                LocalDateTime.now());
        System.out.println(order);
    }
}
