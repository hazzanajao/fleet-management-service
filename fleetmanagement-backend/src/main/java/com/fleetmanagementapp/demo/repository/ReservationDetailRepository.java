package com.fleetmanagementapp.demo.repository;


import com.fleetmanagementapp.demo.model.ReservationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDetailRepository extends JpaRepository<ReservationDetail, Long> {

}
