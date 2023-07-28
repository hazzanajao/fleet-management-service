package com.fleetmanagementapp.demo.service;

import com.fleetmanagementapp.demo.model.ReservationStatus;
import com.fleetmanagementapp.demo.repository.ReservationStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReservationStatusService {
    /**
     * Injecting ReservationStatusRepository for autowiring
     ******************************************/
    @Autowired
    private ReservationStatusRepository reservationStatusRepository;

    public ReservationStatusService(ReservationStatusRepository reservationStatusRepository ){
        this.reservationStatusRepository = reservationStatusRepository;
    }
    /**
     * CRUD : Create, Read, Update and Delete
     **********************************************/

    public ReservationStatus createReservationStatus(ReservationStatus reservationStatus){
        return reservationStatusRepository.save(reservationStatus);
    }
    // Can read all ReservationStatuses
    public List<ReservationStatus> findAllReservationStatuses(){
        return reservationStatusRepository.findAll();
    }
    // Can read one ReservationStatus by id
    public ReservationStatus findReservationStatusById(Long id){
        return reservationStatusRepository.findById(id).orElse(null);
    }
    // Can update ReservationStatus
    public ReservationStatus updateReservationStatus( ReservationStatus reservationStatus){
        return reservationStatusRepository.save(reservationStatus);
    }
    // Can delete ReservationStatus by id
    public void deleteReservationStatusById(Long id){
        reservationStatusRepository.deleteById(id);
    }
}
