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
        CarBodyType bodyType = carBodyTypeService.findCarBodyTypeById(id);
        return bodyType;
    }
    @PostMapping("/car-body-types")
    public CarBodyType createCarBodyType(@RequestBody CarBodyType bodyType){
        return carBodyTypeService.createCarBodyType(bodyType);
    }
    @PutMapping("/car-body-types/{id}")
    public CarBodyType updateCarBodyType(@PathVariable ("id") Long id, @RequestBody CarBodyType bodyType ){
        carBodyTypeService.deleteCarBodyTypeById(id);
        bodyType.setBodyTypeId(id);
        return carBodyTypeService.updateCarBodyType(bodyType);
    }
    @DeleteMapping("/car-body-types/{id}")
    public void deleteCarBodyType(@PathVariable Long id){
        carBodyTypeService.deleteCarBodyTypeById(id);
    }
}
