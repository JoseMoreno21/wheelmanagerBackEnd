package com.example.wheelmanager.service;

import com.example.wheelmanager.domain.model.*;
import com.example.wheelmanager.domain.repository.*;
import com.example.wheelmanager.domain.service.VehicleService;
import com.example.wheelmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public Page<Vehicle> getAllVehicles(Pageable pageable) {
        return vehicleRepository.findAll(pageable);
    }

    @Override
    public Vehicle getVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "Id",vehicleId));
    }

    @Override
    public Vehicle createVehicle(Long brandId, Long statusId, Long vehicleTypeId, Long userId,
                                 Vehicle vehicle) {

       return brandRepository.findById(brandId).map(brand -> {
            vehicle.setBrand(brand);
            statusRepository.findById(statusId).map(status->{
                vehicle.setStatus(status);
                return vehicleRepository.save(vehicle);
            }).orElseThrow(() -> new ResourceNotFoundException( "Status", "Id", statusId));
            vehicleTypeRepository.findById(vehicleTypeId).map(vehicleType->{
                vehicle.setVehicleType(vehicleType);
                return vehicleRepository.save(vehicle);
            }).orElseThrow(() -> new ResourceNotFoundException( "Vehicle Type", "Id", vehicleTypeId));
            userRepository.findById(userId).map(user->{
                vehicle.setUser(user);
                return vehicleRepository.save(vehicle);
            }).orElseThrow(() -> new ResourceNotFoundException( "User", "Id", userId));
            return vehicleRepository.save(vehicle);
        }).orElseThrow(() -> new ResourceNotFoundException( "Brand", "Id", brandId));


    }

    @Override
    public Vehicle updateVehicle(Long brandId, Long statusId, Long vehicleTypeId, Long userId,
                                 Long vehicleId, Vehicle vehicleRequest) {
        if(!brandRepository.existsById(brandId))
            throw new ResourceNotFoundException("Brand" + "Id" + brandId);
        if(!statusRepository.existsById(statusId))
            throw new ResourceNotFoundException("Status" + "Id" + statusId);
        if(!vehicleTypeRepository.existsById(vehicleTypeId))
            throw new ResourceNotFoundException("VehicleType" + "Id" + vehicleTypeId);
        if(!userRepository.existsById(userId))
            throw new ResourceNotFoundException("User" + "Id" + userId);

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle", "Id",vehicleId));
        return vehicleRepository.save(vehicle.setVehicleName(vehicleRequest.getVehicleName())
        .setImageUrl(vehicleRequest.getImageUrl())
        .setCalification(vehicleRequest.getCalification())
        .setDescription(vehicleRequest.getDescription()));
    }

    @Override
    public ResponseEntity<?> deleteVehicle(Long brandId, Long statusId, Long vehicleTypeId, Long userId,
                                           Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle", "Id",vehicleId));
        return ResponseEntity.ok().build();
    }
}
