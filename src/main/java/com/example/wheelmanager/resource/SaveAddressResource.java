package com.example.wheelmanager.resource;

import javax.validation.constraints.NotNull;

public class SaveAddressResource {

    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
    @NotNull
    private String description;


    public Double getLatitude() {
        return latitude;
    }

    public SaveAddressResource setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public SaveAddressResource setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }


    public String getDescription() {
        return description;
    }

    public SaveAddressResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
