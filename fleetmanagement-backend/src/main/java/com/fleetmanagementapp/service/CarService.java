package com.fleetmanagementapp.service;

import com.fleetmanagementapp.dto.CarDTO;
import com.fleetmanagementapp.dto.CarMapper;
import com.fleetmanagementapp.exceptions.NotFoundException;
import com.fleetmanagementapp.model.*;
import com.fleetmanagementapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService {

    /**
     * Injecting CarRepository for autowiring
    ******************************************/
    @Autowired
    private CarRepository carRepository;

    /**
     * All mapped interface repositories should be injected here:
     * 1.carBodyTypeRepository, 2.carBrandRepository, 3.carColorRepository
     * 4.carModelRepository, 5.carStatusRepository 6.carMapper
     ******************************************/
    //1.carBodyTypeRepository
     @Autowired
     private CarBodyTypeRepository carBodyTypeRepository;

     //2.carBrandRepository,
     @Autowired
     private CarBrandRepository carBrandRepository;

    //3.carColorRepository
    @Autowired
    private CarColorRepository carColorRepository;

    //4.carModelRepository
    @Autowired
    private CarModelRepository carModelRepository;
   //5.carStatusRepository
    @Autowired
    private CarStatusRepository carStatusRepository;
    //6.carMapper
    @Autowired
    private CarMapper carMapper;


    /**
     * CRUD : Create, Read, Update and Delete
     **********************************************/

    public Car createCar(CarDTO carDTO){

        CarBodyType bodyType = carBodyTypeRepository.findById(
                carDTO.getBodyTypeId()
        ).orElseThrow(() -> new NotFoundException("BodyType not found"));

        CarBrand carBrand = carBrandRepository.findById(
                carDTO.getBrandId()
        ).orElseThrow(() -> new NotFoundException("CarBrand not found"));
        CarColor carColor = carColorRepository.findById(
                carDTO.getColorId()
        ).orElseThrow(() -> new NotFoundException("CarColor not found"));

        CarModel carModel = carModelRepository.findById(
                carDTO.getModelId()
        ).orElseThrow(() -> new NotFoundException("CarModel not found"));

        CarStatus carStatus = carStatusRepository.findById(
                carDTO.getStatusId()
        ).orElseThrow(() -> new NotFoundException("CarStatus not found"));


        Car car = new Car (
                bodyType,
                carBrand,
                carColor,
                carModel,
                carStatus,
                carDTO.getImageUrl(),
                carDTO.getName(),
                carDTO.getYear(),
                carDTO.getPerDayRent()
        );

        return carRepository.save(car);
    }

    // Can update car
    @Transactional
    public Car updateCar( Long id , CarDTO carDTO, CarBodyType bodyType, CarBrand carBrand, CarColor carColor,
    CarModel carModel, CarStatus carStatus){
        Car setCar = carRepository.findById(id).orElseThrow( () -> new NotFoundException("Car Not Found"));
        setCar.setBodyType(bodyType);
        setCar.setCarBrand(carBrand);
        setCar.setCarColor(carColor);
        setCar.setCarModel(carModel);
        setCar.setCarStatus(carStatus);

        setCar.setImageUrl(carDTO.getImageUrl());
        setCar.setName(carDTO.getName());
        setCar.setYear(carDTO.getYear());
        setCar.setPerDayRent(carDTO.getPerDayRent());

        return carRepository.save(setCar);
    }


    // Can read all cars
    public List<Car> findAllCars(){
        return carRepository.findAll();
    }
    // Can read one car by id
    public Car findCarsById(Long id){
        return carRepository.findById(id).orElse(null);
    }

    // Can delete car by id
    public void deleteCarById(Long id){
        carRepository.deleteById(id);
    }

}
