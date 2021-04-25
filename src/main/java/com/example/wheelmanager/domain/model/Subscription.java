package com.example.wheelmanager.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "subscription")
public class Subscription extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = false, updatable = false)
    @CreatedDate
    private Date startDate;

    @NotNull
    private double price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    public Long getId() {
        return id;
    }

    public Subscription setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescriptions() {
        return description;
    }

    public Subscription setDescriptions(String descriptions) {
        this.description = descriptions;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Subscription setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Subscription setPrice(double price) {
        this.price = price;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Subscription setUser(User user) {
        this.user = user;
        return this;
    }
}
