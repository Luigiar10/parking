package com.luigiarrieta.parking.dto;

import lombok.Data;

@Data
public class VehicleResponseDTO {
    private Long id;
    private String licensePlate;
    private Boolean havePlan;
}
