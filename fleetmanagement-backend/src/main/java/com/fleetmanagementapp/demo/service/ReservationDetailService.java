package com.fleetmanagementapp.demo.service;

import com.fleetmanagementapp.demo.model.ReservationDetail;
import com.fleetmanagementapp.demo.repository.ReservationDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReservationDetailService {
    /**
     * Injecting ReservationDetailRepository for autowiring
     ******************************************/
    @Autowired
    private ReservationDetailRepository reservationDetailRepository;

    public ReservationDetailService(ReservationDetailRepository reservationDetailRepository ){
        this.reservationDetailRepository = reservationDetailRepository;
    }
    /**
     * CRUD : Create, Read, Update and Delete
     **********************************************/

    public ReservationDetail createReservationDetail(ReservationDetail reservationDetail){
        return reservationDetailRepository.save(reservationDetail);
    }
    // Can read all ReservationDetails
    public List<ReservationDetail> findAllReservationDetails(){
        return reservationDetailRepository.findAll();
    }
    // Can read one ReservationDetail by id
    public ReservationDetail findReservationDetailById(Long id){
        return reservationDetailRepository.findById(id).orElse(null);
    }
    // Can update ReservationDetail
    public ReservationDetail updateReservationDetail( ReservationDetail reservationDetail){
        return reservationDetailRepository.save(reservationDetail);
    }
    // Can delete ReservationDetail by id
    public void deleteReservationDetailById(Long id){
        reservationDetailRepository.deleteById(id);
    }
}
