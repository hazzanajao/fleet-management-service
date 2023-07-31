package com.fleetmanagementapp.controller;

import com.fleetmanagementapp.model.CarBrand;
import com.fleetmanagementapp.service.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CarBrandController {

    @Autowired
    private CarBrandService carBrandService;

    @GetMapping("/car-brands")
    public List<CarBrand> findAllCarBrands(){
        return carBrandService.findAllCarBrands();
    }
    @GetMapping("/car-brands/{id}")
    public CarBrand findById(@PathVariable Long id){
        CarBrand carBrand = carBrandService.findCarBrandById(id);
        return carBrand;
    }
    @PostMapping("/car-brands")
    public CarBrand createCarBrand(@RequestBody CarBrand carBrand){
        return carBrandService.createCarBrand(carBrand);
    }
    @PutMapping("/car-brands/{id}")
    public CarBrand updateCarBrand(@PathVariable ("id") Long id, @RequestBody CarBrand carBrand ){
        carBrandService.deleteCarBrandById(id);
        carBrand.setBrandId(id);
        return carBrandService.updateCarBrand(carBrand);
    }
    @DeleteMapping("/car-brands/{id}")
    public void deleteCarBrand(@PathVariable Long id){
        carBrandService.deleteCarBrandById(id);
    }

}
