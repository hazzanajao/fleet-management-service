package com.fleetmanagementapp.demo.repository;

import com.fleetmanagementapp.demo.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository  extends JpaRepository<Branch, Long> {

}
