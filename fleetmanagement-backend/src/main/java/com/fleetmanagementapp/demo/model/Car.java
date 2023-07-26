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
@Table(name = "Car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Car_ID")
    private long carId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "Branch_ID")
    private Branch branch;

    @Column(name = "Car_Code", unique = true, length = 100)
    private String carCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Brand_ID")
    private CarBrand carBrand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Model_ID")
    private CarModel carModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Color_ID")
    private CarColor carColor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BodyType_ID")
    private CarBodyType carBodyType;

    @Column(name="Year")
    private String year;

    @Column(name="Per_day_rent")
    private double perDayRent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Status_ID")
    private CarStatus carStatus;


}