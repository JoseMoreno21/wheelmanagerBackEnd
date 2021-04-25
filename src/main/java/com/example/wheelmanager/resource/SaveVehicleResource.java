package com.example.wheelmanager.resource;

import javax.validation.constraints.NotNull;

public class SaveVehicleResource {
    @NotNull
    private Long id;
    @NotNull
    private String vehicleName;
    @NotNull
    private String imageUrl;
    @NotNull
    private Integer calification;
    @NotNull
    private String description;

    public Long getId() {
        return id;
    }

    public SaveVehicleResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public SaveVehicleResource setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public SaveVehicleResource setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getCalification() {
        return calification;
    }

    public SaveVehicleResource setCalification(Integer calification) {
        this.calification = calification;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveVehicleResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
