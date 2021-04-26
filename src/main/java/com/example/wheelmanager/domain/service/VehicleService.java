package com.example.wheelmanager.domain.service;

import com.example.wheelmanager.domain.model.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface VehicleService {
    Page<Vehicle> getAllVehicles(Pageable pageable);
    Vehicle getVehicleById(Long vehicleId);
    Vehicle createVehicle(Long brandId, Long statusId, Long vehicleTypeId, Long userId,Vehicle vehicleId);
    Vehicle updateVehicle(Long brandId, Long statusId, Long vehicleTypeId, Long userId, Long vehicleId, Vehicle messageRequest);
    ResponseEntity<?> deleteVehicle(Long brandId, Long statusId, Long vehicleTypeId, Long userId, Long vehicleId);
}
