package com.example.wheelmanager.resource;

import com.example.wheelmanager.domain.model.AuditModel;

public class AddressResource extends AuditModel {

    private Long id;

    private  Double latitude;

    private  Double longitude;

    private String description;

    public Long getId() {
        return id;
    }

    public AddressResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public AddressResource setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public AddressResource setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }


    public String getDescription() {
        return description;
    }

    public AddressResource setDescription(String description) {
        this.description = description;
        return this;
    }

}
