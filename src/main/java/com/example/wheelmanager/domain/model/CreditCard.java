package com.example.wheelmanager.domain.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends AuditModel {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String cardNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name= "expiration_date", nullable = false, updatable = false)
    @CreatedDate
    private Date expirationDate;

    @NotNull
    private String cardCcv;

    public Long getId() {
        return id;
    }

    public CreditCard setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public CreditCard setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public CreditCard setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public String getCardCcv() {
        return cardCcv;
    }

    public CreditCard setCardCcv(String cardCcv) {
        this.cardCcv = cardCcv;
        return this;
    }
}
