package com.example.wheelmanager.domain.service;

import com.example.wheelmanager.domain.model.CreditCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CreditCardService {
    Page<CreditCard> getAllCards(Pageable pageable);
    CreditCard getCreditCardById(Long creditCardId);
    CreditCard createCreditCard(Long userId, CreditCard creditCard);
    CreditCard updateCreditCard(Long userId, Long creditCardId, CreditCard messageRequest);
    ResponseEntity<?> deleteCreditCard(Long userId, Long creditCardId);
}
