package com.example.wheelmanager.resource;

import javax.validation.constraints.NotNull;

public class SaveCreditCardResource {
    @NotNull
    private String cardNumber;
    @NotNull
    private String cardCvv;


    public String getCardNumber() {
        return cardNumber;
    }

    public SaveCreditCardResource setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }


    public String getCardCvv() {
        return cardCvv;
    }

    public SaveCreditCardResource setCardCvv(String cardCvv) {
        this.cardCvv = cardCvv;
        return this;
    }
}
