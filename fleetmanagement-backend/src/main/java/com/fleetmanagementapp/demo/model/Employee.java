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
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Employee_ID")
    private long employeeId;

    @ManyToOne
    @JoinColumn (name = "Branch_ID")
    private Branch branch;

    @Column(name = "First_Name", unique = true,length=100)
    private String firstName;

    @Column(name = "Surname",length=100)
    private String surname;

    @Column(name = "Position",length=20)
    private String position;

}
