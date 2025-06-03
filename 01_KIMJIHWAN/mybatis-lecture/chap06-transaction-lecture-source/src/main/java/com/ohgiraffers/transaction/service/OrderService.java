package com.ohgiraffers.transaction.service;

import com.ohgiraffers.transaction.domain.Order;
import com.ohgiraffers.transaction.domain.OrderMenu;
import com.ohgiraffers.transaction.dto.OrderDTO;
import com.ohgiraffers.transaction.dto.OrderMenuDTO;
import com.ohgiraffers.transaction.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    /* 주문 등록 기능 메소드
     * Controller에서 넘어온 DTO를 도메인 모델로 변환 후
     * 주문 정보(tbl_order)와 주문별 메뉴 정보(tbl_order_menu)를
     * 하나의 트랜잭션으로 처리한다.
     * */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void registOrder(OrderDTO orderDTO, List<OrderMenuDTO> orderMenuDTOs) {
        // DTO -> Domain 변환(OrderDTO -> Order)
        Order order = new Order();
        order.setOrderDate(orderDTO.getOrderDate());
        order.setOrderTime(orderDTO.getOrderTime());
        order.setTotalOrderPrice(orderDTO.getTotalOrderPrice());

        // tbl_order에 주문 정보 삽입
        orderMapper.insertOrder(order);

        // DTO -> Domain 변환
        List<OrderMenu> orderMenus = orderMenuDTOs.stream().map(dto ->{
            OrderMenu orderMenu = new OrderMenu();
            orderMenu.setMenuCode(dto.getMenuCode());
            orderMenu.setOrderAmount(dto.getOrderAmount());
            // 주문 등록 후 auto generated 된 orderCode를 각 주문 메뉴에 설정
            orderMenu.setOrderCode(order.getOrderCode());
            return orderMenu;
        }).collect(Collectors.toList());

        // tbl_order_menu에 각 주문 메뉴 정보 삽입
        orderMenus.forEach(orderMapper::insertOrderMenu);
    }
}
