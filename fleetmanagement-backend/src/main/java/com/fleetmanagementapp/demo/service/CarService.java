package com.fleetmanagementapp.demo.service;

import com.fleetmanagementapp.demo.model.Car;
import com.fleetmanagementapp.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    /**
     * Injecting CarRepository for autowiring
    ******************************************/
    @Autowired
    private CarRepository carRepository;

    public CarService(CarRepository carRepository ){
        this.carRepository = carRepository;
    }
    /**
     * CRUD : Create, Read, Update and Delete
     **********************************************/

    public Car createCar(Car car){
        return carRepository.save(car);
    }
    // Can read all cars
    public List<Car> findAllCars(){
        return carRepository.findAll();
    }
    // Can read one car by id
    public Car findCarsById(Long id){
        return carRepository.findById(id).orElse(null);
    }
    // Can update car
    public Car updateCar( Car car){
        return carRepository.save(car);
    }
    // Can delete car by id
    public void deleteCarById(Long id){
        carRepository.deleteById(id);
    }

}
