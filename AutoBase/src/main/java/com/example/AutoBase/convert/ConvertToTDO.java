package com.example.AutoBase.convert;

import com.example.AutoBase.dto.OrderDto;
import com.example.AutoBase.model.CargoType;
import com.example.AutoBase.model.City;
import com.example.AutoBase.model.Order;
import org.springframework.stereotype.Service;

@Service
public class ConvertToTDO {
    public OrderDto convertToOrderDTO(Order order) {
        City city = order.getCity();
        CargoType cargoType = order.getCargoType();
        return new OrderDto(
                order.getId(),
                city.getName(),
                city.getDestination(),
                cargoType.getName(),
                cargoType.getPrice(),
                order.getWeight(),
                order.isFlight()
        );
    }
}
