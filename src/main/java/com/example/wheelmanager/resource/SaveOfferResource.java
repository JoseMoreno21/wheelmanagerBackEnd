package com.example.wheelmanager.resource;

import javax.validation.constraints.NotNull;

public class SaveOfferResource {
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private String imageUrl;
    @NotNull
    private Double offerPrice;

    public String getName() {
        return name;
    }

    public SaveOfferResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveOfferResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public SaveOfferResource setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }


    public Double getOfferPrice() {
        return offerPrice;
    }

    public SaveOfferResource setOfferPrice(Double offerPrice) {
        this.offerPrice = offerPrice;
        return this;
    }
}
