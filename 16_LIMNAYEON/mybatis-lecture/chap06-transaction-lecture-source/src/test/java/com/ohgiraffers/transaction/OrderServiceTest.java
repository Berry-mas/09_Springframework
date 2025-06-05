package com.ohgiraffers.transaction;

import com.ohgiraffers.transaction.dto.OrderDTO;
import com.ohgiraffers.transaction.dto.OrderMenuDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;

class OrderServiceTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @DisplayName("주문 등록 테스트")
    @Test
    public void testRegisterOrder(){

        // given
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

        // then
    }
}
