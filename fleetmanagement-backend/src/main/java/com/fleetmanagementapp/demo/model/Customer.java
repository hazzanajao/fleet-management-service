package com.fleetmanagementapp.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Customer_ID")
    private long customerId;


    @Column(name = "Email", unique = true,length=100)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    @Column(name = "First_Name",length=20)
    private String firstName;

    @Column(name = "Sur_Name", length=20)
    private String surname;

    @Column(name = "Phone",length=20)
    private String phone;

    @Column(name = "Address",length=20)
    private String address;




}
