package com.fleetmanagementapp.controller;


import com.fleetmanagementapp.model.CarStatus;
import com.fleetmanagementapp.service.CarStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CarStatusController {

    @Autowired
    private CarStatusService carStatusService;

    @GetMapping("/car-status")
    public List<CarStatus> findAllCarStatus(){
        return carStatusService.findAllCarStatuses();
    }
    @GetMapping("/car-status/{id}")
    public CarStatus findById(@PathVariable Long id){
        CarStatus carStatus = carStatusService.findCarStatusById(id);
        return carStatus;
    }
    @PostMapping("/car-status")
    public CarStatus createCarStatus(@RequestBody CarStatus carStatus){
        return carStatusService.createCarStatus(carStatus);
    }
    @PutMapping("/car-status/{id}")
    public CarStatus updateCarStatus(@PathVariable ("id") Long id, @RequestBody CarStatus carStatus ){
        carStatusService.deleteCarStatusById(id);
        carStatus.setStatusId(id);
        return carStatusService.updateCarStatus(carStatus);
    }
    @DeleteMapping("/car-status/{id}")
    public void deleteCarStatus(@PathVariable Long id){
        carStatusService.deleteCarStatusById(id);
    }

}
