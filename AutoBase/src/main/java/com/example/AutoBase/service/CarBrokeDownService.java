package com.example.AutoBase.service;

import com.example.AutoBase.model.*;
import com.example.AutoBase.service.busines.carservice.CarService;
import com.example.AutoBase.service.busines.driverservice.DriverService;
import com.example.AutoBase.service.busines.flightservice.FlightService;
import com.example.AutoBase.service.busines.orderservice.OrderService;
import com.example.AutoBase.utils.TestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class CarBrokeDownService {

    @Autowired
    private FlightService flightService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private CarService carService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private HistoryRecorderService historyRecorderService;


    public void carBrokerDown(Flight flight) {
        Flight validFlight = Objects.requireNonNull(flight, "Flight cannot be null...");
        Order order = Objects.requireNonNull(validFlight.getOrder(), "Order cannot be null...");
        Driver driver = Objects.requireNonNull(validFlight.getDriver(), "Driver cannot be null...");
        Car car = Objects.requireNonNull(validFlight.getCar(), "Car cannot be null...");

        // заносим в историю
        historyRecorderService.recordToHistory(order, driver, car, validFlight, true);
        System.out.println("Заносим в историю...");

        // удаляем flight и order
        flightService.delete(validFlight);
        orderService.delete(order);
        System.out.println("Удаляем flight и order...");

        // машину в ремонт
        int timeToRepair = TestUtils.getRandomInteger(1, 3);
        car.setTimeToRepair(timeToRepair);
        carService.update(car);
        System.out.println("Машину в ремонт...");

        // освобождаем водителя
        driver.setFree(true);
        driverService.update(driver);
        System.out.println("Освобождаем водителя...");
    }
}
