package com.example.wheelmanager.resource;

import javax.validation.constraints.NotNull;

public class SaveCreditCardResource {
    @NotNull
    private String cardNumber;
    @NotNull
    private String cardCcv;


    public String getCardNumber() {
        return cardNumber;
    }

    public SaveCreditCardResource setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }


    public String getCardCcv() {
        return cardCcv;
    }

    public SaveCreditCardResource setCardCcv(String cardCcv) {
        this.cardCcv = cardCcv;
        return this;
    }
}
