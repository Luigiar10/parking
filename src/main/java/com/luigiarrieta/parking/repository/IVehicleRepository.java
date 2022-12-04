package com.luigiarrieta.parking.repository;

import com.luigiarrieta.parking.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findByLicensePlate(String license);
}
