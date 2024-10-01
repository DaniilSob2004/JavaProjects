package com.example.AutoBase.service.carservice;

import com.example.AutoBase.model.Car;
import java.util.List;

public interface CarService {
    void save(Car car);
    int[] saveCarsList(List<Car> cars);
    void update(Car car);
    void delete(Car car);
    List<Car> findAll();
    void deleteAll();
}
