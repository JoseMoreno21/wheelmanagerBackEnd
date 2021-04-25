package com.example.wheelmanager.service;

import com.example.wheelmanager.domain.model.Vehicle;
import com.example.wheelmanager.domain.repository.VehicleRepository;
import com.example.wheelmanager.domain.service.VehicleService;
import com.example.wheelmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;


    @Override
    public Page<Vehicle> getAllVehicles(Pageable pageable) {
        return vehicleRepository.findAll(pageable);
    }

    @Override
    public Vehicle getVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "Id",vehicleId));
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicleId) {
        return vehicleRepository.save(vehicleId);
    }

    @Override
    public Vehicle updateVehicle(Long vehicleId, Vehicle vehicleRequest) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle", "Id",vehicleId));
        return vehicleRepository.save(vehicle.setVehicleName(vehicleRequest.getVehicleName())
        .setImageUrl(vehicleRequest.getImageUrl())
        .setCalification(vehicleRequest.getCalification())
        .setDescription(vehicleRequest.getDescription()));
    }

    @Override
    public ResponseEntity<?> deleteVehicle(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle", "Id",vehicleId));
        return ResponseEntity.ok().build();
    }
}
