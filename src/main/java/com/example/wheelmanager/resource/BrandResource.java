package com.example.wheelmanager.resource;

import com.example.wheelmanager.domain.model.AuditModel;

public class BrandResource extends AuditModel {
    private Long id;
    private String brandName;

    public Long getId() {
        return id;
    }

    public BrandResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrandName() {
        return brandName;
    }

    public BrandResource setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }
}
