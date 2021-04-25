package com.example.wheelmanager.resource;

import javax.validation.constraints.NotNull;

public class SaveSubscriptionResource {
    @NotNull
    private String description;

    @NotNull
    private double price;

    public String getDescription() {
        return description;
    }

    public SaveSubscriptionResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public SaveSubscriptionResource setPrice(double price) {
        this.price = price;
        return this;
    }
}
