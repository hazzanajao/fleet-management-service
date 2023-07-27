package com.fleetmanagementapp.demo.service;

import com.fleetmanagementapp.demo.model.CarStatus;
import com.fleetmanagementapp.demo.repository.CarStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarStatusService {
    /**
     * Injecting CarModelRepository for autowiring
     ******************************************/
    @Autowired
    private CarStatusRepository carStatusRepository;

    public CarStatusService(CarStatusRepository carStatusRepository ){
        this.carStatusRepository = carStatusRepository;
    }
    /**
     * CRUD : Create, Read, Update and Delete
     **********************************************/

    public CarStatus createCarStatus(CarStatus carStatus){
        return carStatusRepository.save(carStatus);
    }
    // Can read all carStatuses
    public List<CarStatus> findAllCarStatuses(){
        return carStatusRepository.findAll();
    }
    // Can read carStatus by id
    public CarStatus findCarStatusById(Long id){
        return carStatusRepository.findById(id).orElse(null);
    }
    // Can update carStatus
    public CarStatus updateCarStatus( CarStatus carStatus){
        return carStatusRepository.save(carStatus);
    }
    // Can delete carStatus by id
    public void deleteCarStatusById(Long id){
        carStatusRepository.deleteById(id);
    }
}
