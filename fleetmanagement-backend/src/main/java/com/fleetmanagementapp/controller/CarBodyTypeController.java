package com.fleetmanagementapp.controller;

import com.fleetmanagementapp.model.CarBodyType;
import com.fleetmanagementapp.service.CarBodyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CarBodyTypeController {
    @Autowired
    private CarBodyTypeService carBodyTypeService;

    @GetMapping("/car-body-types")
    public List<CarBodyType> findAllCarBodyTypes(){
        return carBodyTypeService.findAllCarBodyTypes();
    }
    @GetMapping("/car-body-types/{id}")
    public CarBodyType findById(@PathVariable Long id){
        CarBodyType carBodyType = carBodyTypeService.findCarBodyTypeById(id);
        return carBodyType;
    }
    @PostMapping("/car-body-types")
    public CarBodyType createCarBodyType(@RequestBody CarBodyType carBodyType){
        return carBodyTypeService.createCarBodyType(carBodyType);
    }
    @PutMapping("/car-body-types/{id}")
    public CarBodyType updateCarBodyType(@PathVariable ("id") Long id, @RequestBody CarBodyType carBodyType ){
        carBodyTypeService.deleteCarBodyTypeById(id);
        carBodyType.setBodyTypeId(id);
        return carBodyTypeService.updateCarBodyType(carBodyType);
    }
    @DeleteMapping("/car-body-types/{id}")
    public void deleteCarBodyType(@PathVariable Long id){
        carBodyTypeService.deleteCarBodyTypeById(id);
    }
}
