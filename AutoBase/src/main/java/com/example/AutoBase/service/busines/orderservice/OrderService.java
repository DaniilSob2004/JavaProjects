package com.example.AutoBase.service.busines.orderservice;

import com.example.AutoBase.dto.OrderDto;
import com.example.AutoBase.dto.OrderFilterDto;
import com.example.AutoBase.model.Order;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderService {
    void save(Order order);
    int[] saveOrdersList(List<Order> orders);
    void update(Order order);
    void delete(Order order);
    List<Order> findAll();
    void deleteAll();

    float getTotalPrice(Order order);
    List<Order> findNewOrders();
    List<OrderDto> findAllDto();
    List<OrderDto> findByFilter(OrderFilterDto filterDto);
}
