package com.example.wheelmanager.resource;

import com.example.wheelmanager.domain.model.AuditModel;

public class VehicleTypeResource extends AuditModel {
    private Long id;
    private String vehicleTypeName;

    public Long getId() {
        return id;
    }

    public VehicleTypeResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public VehicleTypeResource setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
        return this;
    }
}
