package com.example.AutoBase.service.busines.orderservice;

import com.example.AutoBase.convert.ConvertToTDO;
import com.example.AutoBase.dao.order.OrderRepository;
import com.example.AutoBase.dto.OrderDto;
import com.example.AutoBase.dto.OrderFilterDto;
import com.example.AutoBase.model.CargoType;
import com.example.AutoBase.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ConvertToTDO convertToTDO;


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


    @Override
    public Optional<Order> findById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public float getTotalPrice(Order order) {
        CargoType cargoType = order.getCargoType();
        if (cargoType == null) {
            return -1;
        }
        return cargoType.getPrice() * order.getWeight();
    }

    @Override
    public List<Order> findNewOrders() {
        return orderRepository.findByFlightIsFalse();
    }

    @Override
    public List<OrderDto> findAllDto() {
        return getOrderDto(orderRepository.findAll());
    }

    @Override
    public List<OrderDto> findByFilter(OrderFilterDto filterDto) {
        return getOrderDto(orderRepository.findByFilter(filterDto));
    }


    private List<OrderDto> getOrderDto(List<Order> orders) {
        return orders.stream()
                .map(convertToTDO::convertToOrderDTO)
                .collect(Collectors.toList());
    }
}
