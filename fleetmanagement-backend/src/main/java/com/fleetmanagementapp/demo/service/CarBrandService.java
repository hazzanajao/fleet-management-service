package com.fleetmanagementapp.demo.service;

import com.fleetmanagementapp.demo.model.CarBrand;
import com.fleetmanagementapp.demo.repository.CarBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarBrandService {
    /**
     * Injecting CarBrandRepository for autowiring
     ******************************************/
    @Autowired
    private CarBrandRepository carBrandRepository;

    public CarBrandService(CarBrandRepository carBrandRepository ){
        this.carBrandRepository = carBrandRepository;
    }
    /**
     * CRUD : Create, Read, Update and Delete
     **********************************************/

    public CarBrand createCarBrand( CarBrand carBrand){
        return carBrandRepository.save(carBrand);
    }
    // Can read all carBrands
    public List<CarBrand> findAllCarBrands(){
        return carBrandRepository.findAll();
    }
    // Can read carBrand by id
    public CarBrand findCarBrandById(Long id){
        return carBrandRepository.findById(id).orElse(null);
    }
    // Can update carBrand
    public CarBrand updateCarBrand( CarBrand carBrand){
        return carBrandRepository.save(carBrand);
    }
    // Can delete carBrand by id
    public void deleteCarBrandById(Long id){
        carBrandRepository.deleteById(id);
    }
}
