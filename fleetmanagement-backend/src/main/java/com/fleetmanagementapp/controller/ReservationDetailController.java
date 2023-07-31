package com.fleetmanagementapp.controller;

import com.fleetmanagementapp.model.ReservationDetail;
import com.fleetmanagementapp.service.ReservationDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ReservationDetailController {

   @Autowired
    private ReservationDetailService reservationDetailService;

    @GetMapping("/reservationDetails")
    public List<ReservationDetail> findAllReservationDetails(){
        return reservationDetailService.findAllReservationDetails();
    }
    @GetMapping("/reservationDetails/{id}")
    public ReservationDetail findById(@PathVariable Long id){
        ReservationDetail reservationDetail = reservationDetailService.findReservationDetailById(id);
        return reservationDetail;
    }
    @PostMapping("/reservationDetails")
    public ReservationDetail createReservationDetail(@RequestBody ReservationDetail reservationDetail){
        return reservationDetailService.createReservationDetail(reservationDetail);
    }
    @PutMapping("reservationDetails/{id}")
    public ReservationDetail updateReservationDetail(@PathVariable ("id") Long id, @RequestBody ReservationDetail reservationDetail ){
        reservationDetailService.deleteReservationDetailById(id);
        reservationDetail.setReservationId(id);
        return reservationDetailService.updateReservationDetail(reservationDetail);
    }
    @DeleteMapping("/reservationDetails/{id}")
    public void deleteReservationDetail(@PathVariable Long id){
        reservationDetailService.deleteReservationDetailById(id);
    }
}
