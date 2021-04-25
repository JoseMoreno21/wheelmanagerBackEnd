package com.example.wheelmanager.service;

import com.example.wheelmanager.domain.model.CreditCard;
import com.example.wheelmanager.domain.repository.CreditCardRepository;
import com.example.wheelmanager.domain.service.CreditCardService;
import com.example.wheelmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreditCardServiceImpl implements CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    @Override
    public Page<CreditCard> getAllCards(Pageable pageable)
    {
        return creditCardRepository.findAll(pageable);
    }

    @Override
    public CreditCard getCreditCardById(Long creditCardId){
        return creditCardRepository.findById(creditCardId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "CreditCard", "Id", creditCardId));

    }

    @Override
    public CreditCard createCreditCard(CreditCard creditCard) { return creditCardRepository.save(creditCard); }

    @Override
    public CreditCard updateCreditCard(Long creditCardId, CreditCard creditCardRequest) {
        CreditCard creditCard = creditCardRepository.findById(creditCardId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "CreditCard", "Id", creditCardId));
        return creditCardRepository.save(
                creditCard.setCardNumber(creditCardRequest.getCardNumber())
                        .setCardCcv(creditCardRequest.getCardCcv()));
    }

    @Override
    public ResponseEntity<?> deleteCreditCard(Long creditCardId) {
        CreditCard creditCard = creditCardRepository.findById(creditCardId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "CreditCard", "Id", creditCardId));
        creditCardRepository.delete(creditCard);
        return ResponseEntity.ok().build();
    }

}
