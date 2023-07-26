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
@Table(name = "ReservationStatus")
public class ReservationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Status_ID")
    private long statusId;

    @Column(name = "Reservation_Status", unique = true, length=30)
    private String reservationStatus;


}