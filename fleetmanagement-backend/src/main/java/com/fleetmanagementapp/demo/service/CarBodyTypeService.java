package com.fleetmanagementapp.demo.service;

import com.fleetmanagementapp.demo.model.CarBodyType;
import com.fleetmanagementapp.demo.repository.CarBodyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarBodyTypeService {
    /**
     * Injecting CarBodyTypeRepository for autowiring
     ******************************************/
    @Autowired
    private CarBodyTypeRepository carBodyTypeRepository;

    public CarBodyTypeService(CarBodyTypeRepository carBodyTypeRepository ){
        this.carBodyTypeRepository = carBodyTypeRepository;
    }
    /**
     * CRUD : Create, Read, Update and Delete
     **********************************************/

    public CarBodyType createCarBodyType(CarBodyType carBodyType){
        return carBodyTypeRepository.save(carBodyType);
    }
    // Can read all carBodyTypes
    public List<CarBodyType> findAllCarBodyTypes(){
        return carBodyTypeRepository.findAll();
    }
    // Can read carBodyType by id
    public CarBodyType findCarBodyTypeById(Long id){
        return carBodyTypeRepository.findById(id).orElse(null);
    }
    // Can update carBodyType
    public CarBodyType updateCarBodyType( CarBodyType carBodyType){
        return carBodyTypeRepository.save(carBodyType);
    }
    // Can delete carBodyType by id
    public void deleteCarBodyTypeById(Long id){
        carBodyTypeRepository.deleteById(id);
    }
}
