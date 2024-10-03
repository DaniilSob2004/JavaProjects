package com.example.AutoBase.service.busines.orderservice;

import com.example.AutoBase.model.Order;
import java.util.List;

public interface OrderService {
    void save(Order order);
    int[] saveOrdersList(List<Order> orders);
    void update(Order order);
    void delete(Order order);
    List<Order> findAll();
    void deleteAll();
}
