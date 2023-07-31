package com.fleetmanagementapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Branch_ID")
    private long branchId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "Company_ID")
    private Company company;

    @Column(name = "Branch_name", unique = true, length = 100)
    private String branchName;

    @Column(name = "Address",  length = 100)
    private String address;

    @Column(name = "Phone",  length = 20)
    private String phone;


}