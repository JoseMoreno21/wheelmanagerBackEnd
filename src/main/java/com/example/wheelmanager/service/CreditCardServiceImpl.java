package com.example.wheelmanager.service;

import com.example.wheelmanager.domain.model.CreditCard;
import com.example.wheelmanager.domain.repository.CreditCardRepository;
import com.example.wheelmanager.domain.repository.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

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
    public CreditCard createCreditCard(Long userId, CreditCard creditCard) {
        return userRepository.findById(userId).map(user -> {
            creditCard.setUser(user);
            return creditCardRepository.save(creditCard);
        }).orElseThrow(() -> new ResourceNotFoundException( "User", "Id", userId));
    }

    @Override
    public CreditCard updateCreditCard(Long userId, Long creditCardId, CreditCard creditCardRequest) {
        if(!userRepository.existsById(userId))
            throw new ResourceNotFoundException("User" + "Id" + userId);

        CreditCard creditCard = creditCardRepository.findById(creditCardId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "CreditCard", "Id", creditCardId));
        return creditCardRepository.save(
                creditCard.setCardNumber(creditCardRequest.getCardNumber())
                        .setCardCvv(creditCardRequest.getCardCvv()));
    }

    @Override
    public ResponseEntity<?> deleteCreditCard(Long userId, Long creditCardId) {
        return creditCardRepository.findByIdAndUserId(creditCardId, userId).map(creditCard -> {
            creditCardRepository.delete(creditCard);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Message not found with Id " + creditCardId + " and UserId " + userId));
    }

}
