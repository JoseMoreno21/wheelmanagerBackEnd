package com.example.wheelmanager.domain.repository;

import com.example.wheelmanager.domain.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
