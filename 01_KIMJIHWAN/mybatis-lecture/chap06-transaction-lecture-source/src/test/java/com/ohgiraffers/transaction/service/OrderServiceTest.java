package com.ohgiraffers.transaction.service;

import com.ohgiraffers.transaction.dto.OrderDTO;
import com.ohgiraffers.transaction.dto.OrderMenuDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    // Spring Framework에서 제공하는 클래스로 JDBC를 이용한 데이터베이스접근을 쉽게 해주는 도구
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @DisplayName("주문등록 테스트")
    @Test
    public void testRegisterOrder() {

        // given  -> contoller가정
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderDate("20250529");
        orderDTO.setOrderTime("100430");
        orderDTO.setTotalOrderPrice(50000);

        OrderMenuDTO menuDTO1 = new OrderMenuDTO();
        menuDTO1.setMenuCode(1);
        menuDTO1.setOrderAmount(2);

        OrderMenuDTO menuDTO2 = new OrderMenuDTO();
        menuDTO2.setMenuCode(2);
        menuDTO2.setOrderAmount(3);

        List<OrderMenuDTO> orderMenuDTOS = Arrays.asList(menuDTO1, menuDTO2);

        // when
        orderService.registOrder(orderDTO, orderMenuDTOS);

        // then
        Integer orderCount = jdbcTemplate.queryForObject(
                "select count(*) from tbl_order", Integer.class);
        Integer orderMenuCount = jdbcTemplate.queryForObject(
                "select count(*) from tbl_order_menu", Integer.class);
        assertThat(orderCount).isEqualTo(1);
        assertThat(orderMenuCount).isEqualTo(2);

        String orderDate = jdbcTemplate.queryForObject(
                "SELECT order_date FROM tbl_order", String.class
        );
        assertThat(orderDate).isEqualTo("20250529");
    }
}