package com.example.wheelmanager.resource;

import com.example.wheelmanager.domain.model.AuditModel;

import java.util.Date;

public class UserResource extends AuditModel {

    private Long id;

    private String userName;

    private String password;

    private String email;

    private String name;

    private String lastName;

    private String imageUrl;

    private Long dni;

    private String gender;

    private Date birthDay;


    public Long getId() {
        return id;
    }

    public UserResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserResource setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserResource setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UserResource setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Long getDni() {
        return dni;
    }

    public UserResource setDni(Long dni) {
        this.dni = dni;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public UserResource setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public UserResource setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
        return this;
    }
}
