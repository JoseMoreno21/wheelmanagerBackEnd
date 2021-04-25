package com.example.wheelmanager.resource;

import javax.validation.constraints.NotNull;

public class SaveVehicleTypeResource {
    @NotNull
    private String vehicleTypeName;

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public SaveVehicleTypeResource setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
        return this;
    }
}
