package com.fleetmanagementapp.controller;

import com.fleetmanagementapp.model.Customer;
import com.fleetmanagementapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> findAllCustomers(){
        return customerService.findAllCustomers();
    }
    @GetMapping("/customers/{id}")
    public Customer findById(@PathVariable Long id){
        Customer customer = customerService.findCustomerById(id);
        return customer;
    }
    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }
    @PutMapping("customers/{id}")
    public Customer updateCustomer(@PathVariable ("id") Long id, @RequestBody Customer customer ){
        customerService.deleteCustomerById(id);
        customer.setCustomerId(id);
        return customerService.updateCustomer(customer);
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomerById(id);
    }
}
