package com.fleetmanagementapp.demo.controller;

import com.fleetmanagementapp.demo.model.Company;
import com.fleetmanagementapp.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public List<Company> findAllCompanies(){
        return companyService.findAllCompanies();
    }
    @GetMapping("/companies/{id}")
    public Company findById(@PathVariable Long id){
        Company company = companyService.findCompaniesById(id);
        return company;
    }
    @PostMapping("/companies")
    public Company createCompany(@RequestBody Company company){
        return companyService.createCompany(company);
    }
    @PutMapping("companies/{id}")
    public Company updateCompany(@PathVariable ("id") Long id, @RequestBody Company company ){
        companyService.deleteCompanyById(id);
        company.setCompanyId(id);

        return companyService.updateCompany(company);
    }
    @DeleteMapping("/companies/{id}")
    public void deleteCompany(@PathVariable Long id){
        companyService.deleteCompanyById(id);
    }

}
