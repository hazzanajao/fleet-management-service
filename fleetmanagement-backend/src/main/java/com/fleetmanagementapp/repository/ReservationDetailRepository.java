package com.fleetmanagementapp.repository;


import com.fleetmanagementapp.model.ReservationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDetailRepository extends JpaRepository<ReservationDetail, Long> {

}
