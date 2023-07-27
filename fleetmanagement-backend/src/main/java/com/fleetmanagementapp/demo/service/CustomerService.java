package com.fleetmanagementapp.demo.service;

import com.fleetmanagementapp.demo.model.Customer;
import com.fleetmanagementapp.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    /**
     * Injecting CustomerRepository for autowiring
     ******************************************/
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository ){
        this.customerRepository = customerRepository;
    }
    /**
     * CRUD : Create, Read, Update and Delete
     **********************************************/

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    // Can read all customers
    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }
    // Can read one customer by id
    public Customer findCustomerById(Long id){
        return customerRepository.findById(id).orElse(null);
    }
    // Can update customer
    public Customer updateCustomer( Customer customer){
        return customerRepository.save(customer);
    }
    // Can delete customer by id
    public void deleteCustomerById(Long id){
        customerRepository.deleteById(id);
    }
}
