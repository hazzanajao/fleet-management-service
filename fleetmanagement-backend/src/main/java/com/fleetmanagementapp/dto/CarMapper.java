package com.fleetmanagementapp.dto;

import com.fleetmanagementapp.model.*;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    public Car newCar(CarDTO carDTO, CarBodyType bodyType, CarBrand carBrand,
                      CarColor carColor, CarModel carModel, CarStatus carStatus){

        return new Car(bodyType, carBrand, carColor, carModel, carStatus, carDTO.getImageUrl(), carDTO.getName(), carDTO.getYear(), carDTO.getPerDayRent());
    }
}
