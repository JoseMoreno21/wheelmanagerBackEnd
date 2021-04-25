package com.example.wheelmanager.service;

import com.example.wheelmanager.domain.model.Offer;
import com.example.wheelmanager.domain.repository.OfferRepository;
import com.example.wheelmanager.domain.service.OfferService;
import com.example.wheelmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public Page<Offer> getAllOffers(Pageable pageable)
    {
        return offerRepository.findAll(pageable);
    }

    @Override
    public Offer getOfferById(Long offerId){
        return offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Offer", "Id", offerId));

    }

    @Override
    public Offer createOffer(Offer offer) { return offerRepository.save(offer); }

    @Override
    public Offer updateOffer(Long offerId, Offer offerRequest) {
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Offer", "Id", offerId));
        return offerRepository.save(
                offer.setName(offerRequest.getName())
                     .setDescription(offerRequest.getDescription())
                     .setImageUrl(offerRequest.getImageUrl())
                     .setOfferPrice(offerRequest.getOfferPrice()));
    }

    @Override
    public ResponseEntity<?> deleteOffer(Long offerId) {
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Offer", "Id", offerId));
        offerRepository.delete(offer);
        return ResponseEntity.ok().build();
    }
}
