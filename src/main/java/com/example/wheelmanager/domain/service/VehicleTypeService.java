package com.example.wheelmanager.domain.service;

import com.example.wheelmanager.domain.model.VehicleType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface VehicleTypeService {
    Page<VehicleType> getAllVehicleTypes(Pageable pageable);
    VehicleType getVehicleTypeById(Long vehicleTypeId);
    VehicleType createVehicleType(VehicleType vehicleType);
    VehicleType updateVehicleType(Long vehicleTypeId, VehicleType messageRequest);
    ResponseEntity<?> deleteVehicleType(Long vehicleTypeId);
}
