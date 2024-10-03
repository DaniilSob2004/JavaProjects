package com.example.AutoBase.service.busines.driverservice;

import com.example.AutoBase.model.Driver;
import java.util.List;

public interface DriverService {
    void save(Driver driver);
    int[] saveDriversList(List<Driver> drivers);
    void update(Driver driver);
    void delete(Driver driver);
    List<Driver> findAll();
    void deleteAll();
}
