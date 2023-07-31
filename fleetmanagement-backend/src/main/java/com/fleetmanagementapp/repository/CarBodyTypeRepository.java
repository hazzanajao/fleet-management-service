package com.fleetmanagementapp.repository;

import com.fleetmanagementapp.model.CarBodyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBodyTypeRepository  extends JpaRepository<CarBodyType, Long> {

}
