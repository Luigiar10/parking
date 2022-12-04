package com.luigiarrieta.parking.service.impl;

import com.luigiarrieta.parking.dto.VehicleRequestDTO;
import com.luigiarrieta.parking.dto.VehicleResponseDTO;
import com.luigiarrieta.parking.mapper.VehicleMapper;
import com.luigiarrieta.parking.model.Vehicle;
import com.luigiarrieta.parking.repository.IVehicleRepository;
import com.luigiarrieta.parking.service.IVehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    private IVehicleRepository vehicleRepository;

    @Autowired
    private VehicleMapper vehicleMapper;

    @Override
    public List<VehicleResponseDTO> getVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleResponseDTO> responseDTOS = new ArrayList<>();
        for(Vehicle vehicle : vehicles) {
            responseDTOS.add(vehicleMapper.entityToDto(vehicle));
        }
        log.info("Retornado todos los vehiculos");
        return responseDTOS;
    }

    @Override
    public VehicleResponseDTO getVehicleByLicensePlate(String license) {
        log.info("Vehiculo retornado con la placa: {}", license);
        return vehicleMapper.entityToDto(vehicleRepository.findByLicensePlate(license));
    }

    @Override
    public VehicleResponseDTO saveVehicle(VehicleRequestDTO requestDTO) {
        VehicleResponseDTO responseDTO = new VehicleResponseDTO();
        responseDTO.setLicensePlate(requestDTO.getLicensePlate());
        responseDTO.setHavePlan(requestDTO.getHavePlan());
        Vehicle newVehicle = vehicleRepository.save(vehicleMapper.dtoToEntity(responseDTO));
        responseDTO.setId(newVehicle.getId());
        log.info("Vehiculo guardado con la placa numero: {}", requestDTO.getLicensePlate());
        return responseDTO;
    }
}
