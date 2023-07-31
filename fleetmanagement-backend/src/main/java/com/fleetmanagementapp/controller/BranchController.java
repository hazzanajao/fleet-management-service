package com.fleetmanagementapp.controller;

import com.fleetmanagementapp.model.Branch;
import com.fleetmanagementapp.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping("/car-branches")
    public List<Branch> findAllCarBrands(){
        return branchService.findAllBranches();
    }
    @GetMapping("/car-branches/{id}")
    public  Branch findById(@PathVariable Long id){
        Branch branch = branchService.findBranchesById(id);
        return branch;
    }
    @PostMapping("/car-branches")
    public Branch createBranch(@RequestBody Branch branch){
        return branchService.createBranch(branch);
    }
    @PutMapping("/car-branches/{id}")
    public Branch updateBranch(@PathVariable ("id") Long id, @RequestBody Branch branch ){
        branchService.deleteBranchById(id);
        branch.setBranchId(id);
        return branchService.updateBranch(branch);
    }
    @DeleteMapping("/car-branches/{id}")
    public void deleteBranch(@PathVariable Long id){
        branchService.deleteBranchById(id);
    }
}
