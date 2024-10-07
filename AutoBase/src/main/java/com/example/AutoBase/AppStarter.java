package com.example.AutoBase;

import com.example.AutoBase.model.Car;
import com.example.AutoBase.model.Driver;
import com.example.AutoBase.service.AutoBaseInitializer;
import com.example.AutoBase.service.CarBrokeDownService;
import com.example.AutoBase.service.CompletedFlightService;
import com.example.AutoBase.service.DepartureFlightService;
import com.example.AutoBase.service.busines.carservice.CarService;
import com.example.AutoBase.service.busines.driverservice.DriverService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
public class AppStarter {

    @Autowired
    private AutoBaseInitializer autoBaseInitializer;

    @Autowired
    private DriverService driverService;

    @Autowired
    private CarService carService;

    @Autowired
    private CompletedFlightService completedFlightService;

    @Autowired
    private DepartureFlightService departureFlightService;

    @Autowired
    private CarBrokeDownService carBrokeDownService;

    @Bean
    public ApplicationRunner init() {
        log.info("ApplicationRunner has started");
        return args -> {
            System.out.println("-".repeat(20));
            autoBaseInitializer.autoBaseInitialize();

            Driver driver = driverService.findFreeDriverByExperience(5).orElse(null);
            if (driver == null) {
                System.out.println("Driver not found...");
            }
            else {
                System.out.println("Driver found: " + driver.getId() + " - " + driver.getName() + " - " + driver.getExperience());
            }

            System.out.println("-".repeat(20));

            Car car = carService.findFreeCarByCarrying(400).orElse(null);
            if (car == null) {
                System.out.println("Car not found...");
            }
            else {
                System.out.println("Car found: " + car.getId() + " - " + car.getName() + " - " + car.getCarrying());
            }

            System.out.println("-".repeat(20));
        };
    }
}
