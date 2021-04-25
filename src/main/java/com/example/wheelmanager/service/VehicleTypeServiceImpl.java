package com.example.wheelmanager.service;

import com.example.wheelmanager.domain.model.VehicleType;
import com.example.wheelmanager.domain.repository.VehicleTypeRepository;
import com.example.wheelmanager.domain.service.VehicleTypeService;
import com.example.wheelmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;


    @Override
    public Page<VehicleType> getAllVehicleTypes(Pageable pageable) {
        return vehicleTypeRepository.findAll(pageable);
    }

    @Override
    public VehicleType getVehicleTypeById(Long vehicleTypeId) {
        return vehicleTypeRepository.findById(vehicleTypeId).orElseThrow(() -> new ResourceNotFoundException("VehicleType", "Id",vehicleTypeId));
    }

    @Override
    public VehicleType createVehicleType(VehicleType vehicleTypeId) {
        return vehicleTypeRepository.save(vehicleTypeId);
    }

    @Override
    public VehicleType updateVehicleType(Long vehicleTypeId, VehicleType vehicleTypeRequest) {
        VehicleType vehicleType = vehicleTypeRepository.findById(vehicleTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("VehicleType", "Id",vehicleTypeId));
        return vehicleTypeRepository.save(vehicleType.setTypeName(vehicleTypeRequest.getTypeName()));
    }

    @Override
    public ResponseEntity<?> deleteVehicleType(Long vehicleTypeId) {
        VehicleType vehicleType = vehicleTypeRepository.findById(vehicleTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("VehicleType", "Id",vehicleTypeId));
        vehicleTypeRepository.delete(vehicleType);
        return ResponseEntity.ok().build();
    }
}
