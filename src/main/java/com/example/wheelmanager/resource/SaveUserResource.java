package com.example.wheelmanager.resource;

import javax.validation.constraints.NotNull;

public class SaveUserResource {
    @NotNull
    private String userName;
    @NotNull
    private String password;
    @NotNull
    private String email;
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @NotNull
    private String imageUrl;
    @NotNull
    private Long dni;
    @NotNull
    private String gender;

    public String getUserName() {
        return userName;
    }

    public SaveUserResource setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SaveUserResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SaveUserResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public SaveUserResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SaveUserResource setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public SaveUserResource setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Long getDni() {
        return dni;
    }

    public SaveUserResource setDni(Long dni) {
        this.dni = dni;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public SaveUserResource setGender(String gender) {
        this.gender = gender;
        return this;
    }
}
