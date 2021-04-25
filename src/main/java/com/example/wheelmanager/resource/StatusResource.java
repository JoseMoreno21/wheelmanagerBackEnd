package com.example.wheelmanager.resource;

import com.example.wheelmanager.domain.model.AuditModel;

public class StatusResource extends AuditModel {
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public StatusResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StatusResource setName(String name) {
        this.name = name;
        return this;
    }
}
