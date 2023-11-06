package com.fleetmanagementapp.controller;

import com.fleetmanagementapp.dto.CarDTO;
import com.fleetmanagementapp.dto.CarMapper;
import com.fleetmanagementapp.exceptions.NotFoundException;
import com.fleetmanagementapp.model.*;
import com.fleetmanagementapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CarController {

    @Autowired
    private CarService carService;


    //1.carBodyTypeService
    @Autowired
    private CarBodyTypeService carBodyTypeService;


    //2.carBrandService,
    @Autowired
    private CarBrandService carBrandService;


    //3.carColorService
    @Autowired
    private CarColorService carColorService;


    //4.carModelService
    @Autowired
    private CarModelService carModelService;


    //5.carStatusService
    @Autowired
    private CarStatusService carStatusService;


    //6.carMapper
    @Autowired
    private CarMapper carMapper;



    @PostMapping("/cars")
    public Car createCar(@RequestBody CarDTO carDTO){
        Long bodyTypeId = carDTO.getBodyTypeId();
        CarBodyType bodyType = carBodyTypeService.findCarBodyTypeById(bodyTypeId);
        Long carBrandId = carDTO.getBrandId();
        CarBrand carBrand = carBrandService.findCarBrandById(carBrandId);
        Long carColorId = carDTO.getColorId();
        CarColor carColor = carColorService.findCarColorById(carColorId);
        Long carModelId = carDTO.getModelId();
        CarModel carModel = carModelService.findCarModelById(carModelId);
        Long carStatusId = carDTO.getStatusId();
        CarStatus carStatus = carStatusService.findCarStatusById(carStatusId);
        Car car = carMapper.newCar(carDTO, bodyType, carBrand, carColor, carModel, carStatus);
        return carService.createCar(carDTO);
    }


    @GetMapping("/cars")
    public List<Car> findAllCars(){
        return carService.findAllCars();
    }

    @GetMapping("/cars/{id}")
    public Car findById(@PathVariable Long id){
        Car car = carService.findCarsById(id);
        if (car == null){
            throw new NotFoundException("Car not found");
        }
        return car;
    }

    @PutMapping("/cars/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody CarDTO carDTO ){
        Car setCar = carService.findCarsById(id);

        if ( setCar == null){
            throw new NotFoundException("Car not found");
        }

        Long bodyTypeId = carDTO.getBodyTypeId();
        CarBodyType bodyType = carBodyTypeService.findCarBodyTypeById(bodyTypeId);

        Long brandId = carDTO.getBrandId();
        CarBrand carBrand = carBrandService.findCarBrandById(brandId);

        Long colorId = carDTO.getColorId();
        CarColor carColor = carColorService.findCarColorById(colorId);

        Long modelId = carDTO.getModelId();
        CarModel carModel = carModelService.findCarModelById(modelId);

        Long statusId = carDTO.getStatusId();
        CarStatus carStatus = carStatusService.findCarStatusById(statusId);


        return carService.updateCar(id, carDTO, bodyType, carBrand, carColor, carModel, carStatus);
    }
    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable Long id){
        carService.deleteCarById(id);
    }

}
