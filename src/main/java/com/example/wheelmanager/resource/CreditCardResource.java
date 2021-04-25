package com.example.wheelmanager.resource;

import com.example.wheelmanager.domain.model.AuditModel;

import java.util.Date;

public class CreditCardResource extends AuditModel {
    private Long id;
    private String cardNumber;
    private Date expirationDate;
    private String cardCvv;

    public Long getId() {
        return id;
    }

    public CreditCardResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public CreditCardResource setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public CreditCardResource setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public String getCardCvv() {
        return cardCvv;
    }

    public CreditCardResource setCardCvv(String cardCvv) {
        this.cardCvv = cardCvv;
        return this;
    }

}
