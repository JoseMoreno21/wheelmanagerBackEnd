package com.example.wheelmanager.controller;

import com.example.wheelmanager.domain.model.CreditCard;
import com.example.wheelmanager.domain.service.CreditCardService;
import com.example.wheelmanager.resource.CreditCardResource;
import com.example.wheelmanager.resource.SaveCreditCardResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "CreditCard", description = "CreditCard API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class CreditCardController {
    @Autowired
    CreditCardService creditCardService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping("/creditcards")
    public Page<CreditCardResource> getAllCards(Pageable pageable) {

        Page<CreditCard> creditCardsPage = creditCardService.getAllCards(pageable);
        List<CreditCardResource> resources = creditCardsPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/creditcards/{creditCardId}")
    public CreditCardResource getCreditCardById(@PathVariable(value = "creditCardId") Long creditCardId) {
        return convertToResource(creditCardService.getCreditCardById(creditCardId));
    }

    @PostMapping("/users/{userId}/creditcards")
    public CreditCardResource createCreditCard(@PathVariable(value = "userId") Long userId,
            @Valid @RequestBody SaveCreditCardResource resource) {
        CreditCard creditCard = convertToEntity(resource);
        return convertToResource(creditCardService.createCreditCard(userId, creditCard));

    }

    @PutMapping("/users/{userId}/creditcards/{creditCardId}")
    public CreditCardResource updateCreditCard(@PathVariable (value = "userId") Long userId,
            @PathVariable Long creditCardId, @Valid @RequestBody SaveCreditCardResource resource) {
        CreditCard creditCard = convertToEntity(resource);
        return convertToResource(
                creditCardService.updateCreditCard(userId, creditCardId, creditCard));
    }

    @DeleteMapping("/users/{userId}/creditcards/{creditCardId}")
    public ResponseEntity<?> deleteCreditCard(@PathVariable (value = "userId") Long userId,
                                              @PathVariable Long creditCardId) {
        return creditCardService.deleteCreditCard(userId, creditCardId);
    }

    private CreditCard convertToEntity(SaveCreditCardResource resource) {

        return mapper.map(resource, CreditCard.class);
    }

    private CreditCardResource convertToResource(CreditCard entity) {
        return mapper.map(entity, CreditCardResource.class);
    }

}
