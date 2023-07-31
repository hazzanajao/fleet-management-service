package com.fleetmanagementapp.controller;

import com.fleetmanagementapp.model.ReservationStatus;
import com.fleetmanagementapp.service.ReservationStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ReservationStatusController {
    @Autowired
    private ReservationStatusService reservationStatusService;

    @GetMapping("/reservationStatuses")
    public List<ReservationStatus> findAllReservationStatuses(){
        return reservationStatusService.findAllReservationStatuses();
    }
    @GetMapping("/reservationStatuses/{id}")
    public ReservationStatus findById(@PathVariable Long id){
        ReservationStatus reservationStatus = reservationStatusService.findReservationStatusById(id);
        return reservationStatus;
    }
    @PostMapping("/reservationStatuses")
    public ReservationStatus createReservationStatus(@RequestBody ReservationStatus reservationStatus){
        return reservationStatusService.createReservationStatus(reservationStatus);
    }
    @PutMapping("reservationStatuses/{id}")
    public ReservationStatus updateReservationStatus(@PathVariable ("id") Long id, @RequestBody ReservationStatus reservationStatus ){
        reservationStatusService.deleteReservationStatusById(id);
        reservationStatus.setStatusId(id);
        return reservationStatusService.updateReservationStatus(reservationStatus);
    }
    @DeleteMapping("/reservationStatuses/{id}")
    public void deleteReservationStatus(@PathVariable Long id){
        reservationStatusService.deleteReservationStatusById(id);
    }
}
