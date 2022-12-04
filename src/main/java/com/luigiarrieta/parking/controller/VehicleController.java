package com.luigiarrieta.parking.controller;

import com.luigiarrieta.parking.dto.VehicleRequestDTO;
import com.luigiarrieta.parking.dto.VehicleResponseDTO;
import com.luigiarrieta.parking.service.impl.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleServiceImpl vehicleService;

    @GetMapping
    public ResponseEntity<List<VehicleResponseDTO>> getAllVehicles() {
        return new ResponseEntity<>(vehicleService.getVehicles(), HttpStatus.OK);
    }

    @GetMapping(
            params = "license"
    )
    public ResponseEntity<VehicleResponseDTO> getVehicleByLicense(@RequestParam String license) {
        return new ResponseEntity<>(vehicleService.getVehicleByLicensePlate(license), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VehicleResponseDTO> saveVehicle(@RequestBody VehicleRequestDTO requestDTO) {
        return new ResponseEntity<>(vehicleService.saveVehicle(requestDTO), HttpStatus.CREATED);
    }

}
