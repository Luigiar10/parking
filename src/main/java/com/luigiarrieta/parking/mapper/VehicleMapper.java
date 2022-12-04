package com.luigiarrieta.parking.mapper;

import com.luigiarrieta.parking.dto.VehicleResponseDTO;
import com.luigiarrieta.parking.model.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public Vehicle dtoToEntity(VehicleResponseDTO responseDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(responseDTO.getId());
        vehicle.setLicensePlate(responseDTO.getLicensePlate());
        vehicle.setHavePlan(responseDTO.getHavePlan());
        return vehicle;
    }

    public VehicleResponseDTO entityToDto(Vehicle vehicle) {
        VehicleResponseDTO responseDTO = new VehicleResponseDTO();
        responseDTO.setId(vehicle.getId());
        responseDTO.setLicensePlate(vehicle.getLicensePlate());
        responseDTO.setHavePlan(vehicle.getHavePlan());
        return responseDTO;
    }

}
