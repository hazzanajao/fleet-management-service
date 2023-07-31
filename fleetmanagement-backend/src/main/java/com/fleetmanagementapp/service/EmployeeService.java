package com.fleetmanagementapp.service;

import com.fleetmanagementapp.model.Employee;
import com.fleetmanagementapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    /**
     * Injecting EmployeeRepository for autowiring
     ******************************************/
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository ){
        this.employeeRepository = employeeRepository;
    }
    /**
     * CRUD : Create, Read, Update and Delete
     **********************************************/

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    // Can read all employees
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }
    // Can read one employee by id
    public Employee findEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }
    // Can update employee
    public Employee updateEmployee( Employee employee){
        return employeeRepository.save(employee);
    }
    // Can delete employee by id
    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }
}
