package com.luigiarrieta.parking.service;

import com.luigiarrieta.parking.dto.VehicleRequestDTO;
import com.luigiarrieta.parking.dto.VehicleResponseDTO;

import java.util.List;

public interface IVehicleService {
    List<VehicleResponseDTO> getVehicles();
    VehicleResponseDTO getVehicleByLicensePlate(String license);
    VehicleResponseDTO saveVehicle(VehicleRequestDTO requestDTO);
}
