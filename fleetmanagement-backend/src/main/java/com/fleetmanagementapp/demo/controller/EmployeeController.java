package com.fleetmanagementapp.demo.controller;

import com.fleetmanagementapp.demo.model.Employee;
import com.fleetmanagementapp.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return employeeService.findAllEmployees();
    }
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return employee;
    }
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }
    @PutMapping("employees/{id}")
    public Employee updateEmployee(@PathVariable ("id") Long id, @RequestBody Employee employee ){
        employeeService.deleteEmployeeById(id);
        employee.setEmployeeId(id);
        return employeeService.updateEmployee(employee);
    }
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
    }
}
