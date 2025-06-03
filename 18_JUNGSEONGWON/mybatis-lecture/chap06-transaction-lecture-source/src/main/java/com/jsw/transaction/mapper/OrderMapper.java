package com.jsw.transaction.mapper;


import com.jsw.transaction.domain.Order;
import com.jsw.transaction.domain.OrderMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    void insertOrder(Order order);

    void insertOrderMenu(OrderMenu orderMenu);
}
