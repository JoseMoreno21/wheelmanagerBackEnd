package com.example.wheelmanager.resource;

import com.example.wheelmanager.domain.model.AuditModel;

public class VehicleResource extends AuditModel {

    private Long id;

    private String vehicleName;

    private String imageUrl;

    private Integer calification;

    private String description;

    public Long getId() {
        return id;
    }

    public VehicleResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public VehicleResource setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public VehicleResource setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getCalification() {
        return calification;
    }

    public VehicleResource setCalification(Integer calification) {
        this.calification = calification;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public VehicleResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
