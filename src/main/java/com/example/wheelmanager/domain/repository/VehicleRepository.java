package com.example.wheelmanager.domain.repository;

import com.example.wheelmanager.domain.model.User;
import com.example.wheelmanager.domain.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByIdAndBrandId(Long id, Long brandId);
    Optional<Vehicle> findByIdAndStatusId(Long id, Long statusId);
    Optional<Vehicle> findByIdAndVehicleTypeId(Long id, Long vehicleTypeId);
    Optional<Vehicle> findByIdAndUserId(Long id, Long userId);
}
