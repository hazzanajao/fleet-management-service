package com.fleetmanagementapp.demo.repository;

import com.fleetmanagementapp.demo.model.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationStatusRepository extends JpaRepository<ReservationStatus, Long> {

}
