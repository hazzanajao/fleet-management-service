package com.fleetmanagementapp.demo.service;

import com.fleetmanagementapp.demo.model.Company;
import com.fleetmanagementapp.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    /**
     * Injecting CompanyRepository for autowiring
     ******************************************/
    @Autowired
    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository ){
        this.companyRepository = companyRepository;
    }
    /**
     * CRUD : Create, Read, Update and Delete
     **********************************************/

    public Company createCompany(Company company){
        return companyRepository.save(company);
    }
    // Can read all companies
    public List<Company> findAllCompanies(){
        return companyRepository.findAll();
    }
    // Can read one company by id
    public Company findCompaniesById(Long id){
        return companyRepository.findById(id).orElse(null);
    }
    // Can update company
    public Company updateCompany( Company company){
        return companyRepository.save(company);
    }
    // Can delete company by id
    public void deleteCompanyById(Long id){
        companyRepository.deleteById(id);
    }
}
