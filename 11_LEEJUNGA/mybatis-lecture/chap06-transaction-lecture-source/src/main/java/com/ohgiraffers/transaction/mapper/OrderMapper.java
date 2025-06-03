package com.ohgiraffers.transaction.mapper;

import com.ohgiraffers.transaction.domain.Order;
import com.ohgiraffers.transaction.domain.OrderMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    void insertOrder(Order order);

    void insertOrderMenu(OrderMenu orderMenu);
}
