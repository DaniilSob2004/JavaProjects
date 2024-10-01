package com.example.AutoBase.dao.cargoType;

import com.example.AutoBase.model.CargoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CargoTypeRepository extends JpaRepository<CargoType, Integer> {

}
