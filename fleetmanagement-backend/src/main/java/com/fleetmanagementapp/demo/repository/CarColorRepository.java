package com.fleetmanagementapp.demo.repository;

import com.fleetmanagementapp.demo.model.CarColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarColorRepository extends JpaRepository<CarColor, Long> {

}
