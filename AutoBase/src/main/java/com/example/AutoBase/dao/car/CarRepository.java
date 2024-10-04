package com.example.AutoBase.dao.car;

import com.example.AutoBase.model.Car;
import com.example.AutoBase.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query("SELECT c FROM Car c WHERE c.carrying >= :carrying AND c.isFree = true")
    List<Car> findFreeCarsByCarrying(@Param("carrying") float carrying);
}
