package com.example.AutoBase.service.busines.carservice;

import com.example.AutoBase.model.Car;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarService {
    void save(Car car);
    int[] saveCarsList(List<Car> cars);
    void update(Car car);
    void delete(Car car);
    List<Car> findAll();
    void deleteAll();

    Optional<Car> findFreeCarByCarrying(float carrying);
}
