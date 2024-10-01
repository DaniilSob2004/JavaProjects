package com.example.AutoBase.service.orderservice;

import com.example.AutoBase.dao.order.OrderRepository;
import com.example.AutoBase.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public int[] saveOrdersList(List<Order> orders) {
        orderRepository.saveAll(orders);
        return new int[0];
    }

    @Override
    public void update(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteAll() {
        orderRepository.deleteAll();
    }
}
