package com.fleetmanagementapp.controller;

import com.fleetmanagementapp.model.Car;
import com.fleetmanagementapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public List<Car> findAllCars(){
        return carService.findAllCars();
    }
    @GetMapping("/cars/{id}")
    public Car findById(@PathVariable Long id){
        Car car = carService.findCarsById(id);
        return car;
    }
    @PostMapping("/cars")
    public Car createCar(@RequestBody Car car){
        return carService.createCar(car);
    }
    @PutMapping("/cars/{id}")
    public Car updateCar(@PathVariable ("id") Long id, @RequestBody Car car ){
        carService.deleteCarById(id);
        car.setCarId(id);
        return carService.updateCar(car);
    }
    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable Long id){
        carService.deleteCarById(id);
    }

}
