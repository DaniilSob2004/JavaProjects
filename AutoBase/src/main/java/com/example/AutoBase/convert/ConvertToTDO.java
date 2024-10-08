package com.example.AutoBase.convert;

import com.example.AutoBase.dto.FlightDto;
import com.example.AutoBase.dto.OrderDto;
import com.example.AutoBase.model.*;
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

    public FlightDto convertToFlightDTO(Flight flight) {
        Order order = flight.getOrder();
        City city = order.getCity();
        Car car = flight.getCar();
        Driver driver = flight.getDriver();
        CargoType cargoType = order.getCargoType();
        return new FlightDto(
                flight.getId(),
                city.getName(),
                city.getDestination(),
                cargoType.getName(),
                order.getWeight(),
                driver.getName() + " " + driver.getSurname(),
                car.getName(),
                flight.getCountDayWay()
        );
    }
}
