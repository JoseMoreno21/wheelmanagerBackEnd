package com.example.wheelmanager.domain.model;



import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "brands")
public class Brand extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String brandName;

    public Brand setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public Brand setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }
}
