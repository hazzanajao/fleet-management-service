package com.fleetmanagementapp.controller;

import com.fleetmanagementapp.model.CarColor;
import com.fleetmanagementapp.model.CarModel;
import com.fleetmanagementapp.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CarModelController {

    @Autowired
    private CarModelService carModelService;

    @GetMapping("/car-models")
    public List<CarModel> findAllCarModels(){
        return carModelService.findAllCarModels();
    }
    @GetMapping("/car-models/{id}")
    public CarModel findById(@PathVariable Long id){
        CarModel carModel = carModelService.findCarModelById(id);
        return carModel;
    }
    @PostMapping("/car-models")
    public CarModel createCarModel(@RequestBody CarModel carModel){
        return carModelService.createCarModel(carModel);
    }
    @PutMapping("/car-models/{id}")
    public CarModel updateCarModel(@PathVariable ("id") Long id, @RequestBody CarModel carModel ){
        carModelService.deleteCarModelById(id);
        carModel.setModelId(id);
        return carModelService.updateCarModel(carModel);
    }
    @DeleteMapping("/car-models/{id}")
    public void deleteCarModel(@PathVariable Long id){
        carModelService.deleteCarModelById(id);
    }
}
