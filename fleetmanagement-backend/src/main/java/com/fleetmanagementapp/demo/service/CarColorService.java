package com.fleetmanagementapp.demo.service;

import com.fleetmanagementapp.demo.model.CarColor;
import com.fleetmanagementapp.demo.repository.CarColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarColorService {
    /**
     * Injecting CarColorRepository for autowiring
     ******************************************/
    @Autowired
    private CarColorRepository carColorRepository;

    public CarColorService(CarColorRepository carColorRepository ){
        this.carColorRepository = carColorRepository;
    }
    /**
     * CRUD : Create, Read, Update and Delete
     **********************************************/

    public CarColor createCarColor(CarColor carColor){
        return carColorRepository.save(carColor);
    }
    // Can read all carColors
    public List<CarColor> findAllCarColors(){
        return carColorRepository.findAll();
    }
    // Can read carColor by id
    public CarColor findCarColorById(Long id){
        return carColorRepository.findById(id).orElse(null);
    }
    // Can update carColor
    public CarColor updateCarColor( CarColor carColor){
        return carColorRepository.save(carColor);
    }
    // Can delete carColor by id
    public void deleteCarColorById(Long id){
        carColorRepository.deleteById(id);
    }
}
