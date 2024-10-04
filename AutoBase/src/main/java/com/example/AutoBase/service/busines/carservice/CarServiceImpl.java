package com.example.AutoBase.service.busines.carservice;

import com.example.AutoBase.dao.car.CarRepository;
import com.example.AutoBase.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;


    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public int[] saveCarsList(List<Car> cars) {
        carRepository.saveAll(cars);
        return new int[0];
    }

    @Override
    public void update(Car car) {
        carRepository.save(car);
    }

    @Override
    public void delete(Car car) {
        carRepository.delete(car);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public void deleteAll() {
        carRepository.deleteAll();
    }


    @Override
    public Optional<Car> findFreeCarByCarrying(float carrying) {
        return carRepository.findFreeCarsByCarrying(carrying)
                .stream()
                .min(Comparator.comparing(Car::getCarrying));
    }
}
