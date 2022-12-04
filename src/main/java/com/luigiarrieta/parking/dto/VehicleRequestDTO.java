package com.luigiarrieta.parking.dto;

import lombok.Data;

@Data
public class VehicleRequestDTO {
    private String licensePlate;
    private Boolean havePlan;
}
