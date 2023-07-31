package com.fleetmanagementapp.service;

import com.fleetmanagementapp.model.CarModel;
import com.fleetmanagementapp.repository.CarModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarModelService {
    /**
     * Injecting CarModelRepository for autowiring
     ******************************************/
    @Autowired
    private CarModelRepository carModelRepository;

    public CarModelService(CarModelRepository carModelRepository ){
        this.carModelRepository = carModelRepository;
    }
    /**
     * CRUD : Create, Read, Update and Delete
     **********************************************/

    public CarModel createCarModel(CarModel carModel){
        return carModelRepository.save(carModel);
    }
    // Can read all carModels
    public List<CarModel> findAllCarModels(){
        return carModelRepository.findAll();
    }
    // Can read carModel by id
    public CarModel findCarModelById(Long id){
        return carModelRepository.findById(id).orElse(null);
    }
    // Can update carModel
    public CarModel updateCarModel( CarModel carModel){
        return carModelRepository.save(carModel);
    }
    // Can delete carModel by id
    public void deleteCarModelById(Long id){
        carModelRepository.deleteById(id);
    }
}
