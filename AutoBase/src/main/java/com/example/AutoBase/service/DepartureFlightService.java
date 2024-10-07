package com.example.AutoBase.service;

import com.example.AutoBase.exceptions.*;
import com.example.AutoBase.model.*;
import com.example.AutoBase.service.busines.carservice.CarService;
import com.example.AutoBase.service.busines.driverservice.DriverService;
import com.example.AutoBase.service.busines.flightservice.FlightService;
import com.example.AutoBase.service.busines.orderservice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class DepartureFlightService {

    @Value("${value.averageCarSpeed}")
    private int averageCarSpeed;

    @Autowired
    private OrderService orderService;

    @Autowired
    private FlightService flightService;

    @Autowired
    private CarService carService;

    @Autowired
    private DriverService driverService;


    public void departureFlight(Order order) {
        Order validOrder = Objects.requireNonNull(order, "Order cannot be null...");

        CargoType cargoType = Objects.requireNonNull(validOrder.getCargoType(), "Cargo type cannot be null...");
        City city = Objects.requireNonNull(validOrder.getCity(), "City cannot be null...");

        // находим свободную машину
        Car car = carService.findFreeCarByCarrying(order.getWeight())
                .orElseThrow(() -> new CarIsNotFoundException("Free car for carrying " + order.getWeight() + " not found..."));
        System.out.println("Находим свободную машину...");

        // находим водителя с нужным опытом
        Driver driver = driverService.findFreeDriverByExperience(cargoType.getDriverExp())
                .orElseThrow(() -> new DriverIsNotFoundException("Free driver for experience " + cargoType.getDriverExp() + " not found..."));
        System.out.println("Находим водителя с нужным опытом...");

        // считаем продолжительность дней поездки
        float average = city.getDestination() / averageCarSpeed;
        int countDayWay = (int) Math.ceil(average);
        System.out.println("Считаем продолжительность дней поездки...");

        // создаём Flight
        Flight flight = new Flight(0, order, car, driver, countDayWay, LocalDateTime.now());
        flightService.save(flight);
        System.out.println("Создаём Flight...");

        // устанавливаем флаг в order
        order.setFlight(true);
        orderService.update(order);
        System.out.println("Устанавливаем флаг в order...");
    }
}
