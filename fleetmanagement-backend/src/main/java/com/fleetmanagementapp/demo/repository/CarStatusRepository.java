package com.fleetmanagementapp.demo.repository;


import com.fleetmanagementapp.demo.model.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarStatusRepository extends JpaRepository<CarStatus, Long> {

}
