package com.example.wheelmanager.resource;

import javax.validation.constraints.NotNull;

public class SaveBrandResource {
    @NotNull
    private String brandName;

    public String getBrandName() {
        return brandName;
    }

    public SaveBrandResource setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }
}
