package com.example.wheelmanager.resource;

import com.example.wheelmanager.domain.model.AuditModel;

import java.util.Date;

public class SubscriptionResource extends AuditModel {
    private Long id;

    private String description;

    private Date startDate;

    private double price;

    public Long getId() {
        return id;
    }

    public SubscriptionResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SubscriptionResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public SubscriptionResource setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public SubscriptionResource setPrice(double price) {
        this.price = price;
        return this;
    }
}
