package com.example.wheelmanager.resource;

import javax.validation.constraints.NotNull;

public class SaveStatusResource {
    @NotNull
    private String name;


    public String getName() {
        return name;
    }

    public SaveStatusResource setName(String name) {
        this.name = name;
        return this;
    }
}
