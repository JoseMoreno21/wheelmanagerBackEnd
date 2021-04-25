package com.example.wheelmanager.domain.service;

import com.example.wheelmanager.domain.model.Offer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface OfferService {
    Page<Offer> getAllOffers(Pageable pageable);
    Offer getOfferById(Long offerId);
    Offer createOffer(Offer offerId);
    Offer updateOffer(Long offerId, Offer messageRequest);
    ResponseEntity<?> deleteOffer(Long offerId);
}
