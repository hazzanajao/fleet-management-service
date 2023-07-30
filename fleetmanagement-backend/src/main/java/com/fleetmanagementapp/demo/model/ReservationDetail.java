package com.fleetmanagementapp.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="ReservationDetail")
public class ReservationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Reservation_ID")
    private long reservationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "Customer_ID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "Car_ID")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "Branch_ID")
    private Branch branch;

    @Column(name="Booking_Date")
    private Date bookingDate;

    @Column(name="Date_From")
    private Date dateFrom;

    @Column(name="Date_To")
    private Date dateTo;

    @Column(name="TotalCost")
    private double totalCost;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "Status_ID")
    private ReservationStatus reservationStatus;

    @Column(name = "Received_Amount")
    private double receivedAmount;



}
