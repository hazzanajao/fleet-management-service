package com.fleetmanagementapp.service;

import com.fleetmanagementapp.model.Branch;
import com.fleetmanagementapp.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {
    /**
     * Injecting BranchRepository for autowiring
     ******************************************/
    @Autowired
    private BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository ){
        this.branchRepository = branchRepository;
    }
    /**
     * CRUD : Create, Read, Update and Delete
     **********************************************/

    public Branch createBranch(Branch branch){
        return branchRepository.save(branch);
    }
    // Can read all branches
    public List<Branch> findAllBranches(){
        return branchRepository.findAll();
    }
    // Can read one branch by id
    public Branch findBranchesById(Long id){
        return branchRepository.findById(id).orElse(null);
    }
    // Can update branch
    public Branch updateBranch( Branch branch){
        return branchRepository.save(branch);
    }
    // Can delete branch by id
    public void deleteBranchById(Long id){
        branchRepository.deleteById(id);
    }

}
