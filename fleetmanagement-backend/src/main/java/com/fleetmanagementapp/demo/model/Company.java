package com.fleetmanagementapp.demo.model;

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
@Table(name = "Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Company_ID")
    private long companyId;

    @Column(name = "Company_Name", unique = true, length=100)
    private String companyName;

    @Column(name = "Address", length=200)
    private String address;

    @Column(name = "Owner",length=100)
    private String owner;

    @Column(name = "Website",length=100)
    private String website;

    @Column(name = "Email",length=100)
    private String email;

    @Column(name = "Phone",length=20)
    private String phone;




}