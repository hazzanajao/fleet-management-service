package com.fleetmanagementapp.controller;

import com.fleetmanagementapp.model.CarColor;
import com.fleetmanagementapp.service.CarColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CarColorController {
    @Autowired
    private CarColorService carColorService;

    @GetMapping("/car-colors")
    public List<CarColor> findAllCarColors(){
        return carColorService.findAllCarColors();
    }
    @GetMapping("/car-colors/{id}")
    public CarColor findById(@PathVariable Long id){
        CarColor carColor = carColorService.findCarColorById(id);
        return carColor;
    }
    @PostMapping("/car-colors")
    public CarColor createCarColor(@RequestBody CarColor carColor){
        return carColorService.createCarColor(carColor);
    }
    @PutMapping("/car-colors/{id}")
    public CarColor updateCarColor(@PathVariable ("id") Long id, @RequestBody CarColor carColor ){
        carColorService.deleteCarColorById(id);
        carColor.setColorId(id);
        return carColorService.updateCarColor(carColor);
    }
    @DeleteMapping("/car-colors/{id}")
    public void deleteCarColor(@PathVariable Long id){
        carColorService.deleteCarColorById(id);
    }
}
