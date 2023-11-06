package com.fleetmanagementapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarDTO {
    private long branchId;
    private long bodyTypeId;
    private long brandId;
    private long modelId;
    private long colorId;
    private long statusId;

    private String imageUrl;
    private String name;
    private String year;
    private double perDayRent;
}
