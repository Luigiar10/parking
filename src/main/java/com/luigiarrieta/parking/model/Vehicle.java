package com.luigiarrieta.parking.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehicle")
    private Long id;
    @Column(name = "license_plate")
    private String licensePlate;
    @Column(name = "have_plan")
    private Boolean havePlan;
}
