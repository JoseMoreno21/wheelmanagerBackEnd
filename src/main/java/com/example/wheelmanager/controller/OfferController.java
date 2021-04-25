package com.example.wheelmanager.controller;

import com.example.wheelmanager.domain.model.Offer;
import com.example.wheelmanager.domain.service.OfferService;
import com.example.wheelmanager.resource.OfferResource;
import com.example.wheelmanager.resource.SaveOfferResource;
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

@Tag(name = "Offer", description = "Offer API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class OfferController {
    @Autowired
    OfferService offerService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping("/offers")
    public Page<OfferResource> getAllOffers(Pageable pageable) {

        Page<Offer> offerPage = offerService.getAllOffers(pageable);
        List<OfferResource> resources = offerPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/offers/{offerId}")
    public OfferResource getOfferById(@PathVariable(value = "offerId") Long offerId) {
        return convertToResource(offerService.getOfferById(offerId));
    }

    @PostMapping("/offers")
    public OfferResource createOffer(
            @Valid @RequestBody SaveOfferResource resource) {
        Offer offer = convertToEntity(resource);
        return convertToResource(offerService.createOffer(offer));

    }

    @PutMapping("/offers/{offerId}")
    public OfferResource updateOffer(@PathVariable Long offerId,
                                       @Valid @RequestBody SaveOfferResource resource) {
        Offer offer = convertToEntity(resource);
        return convertToResource(
                offerService.updateOffer(offerId, offer));
    }

    @DeleteMapping("/offers/{offerId}")
    public ResponseEntity<?> deleteOffer(@PathVariable Long offerId) {
        return offerService.deleteOffer(offerId);
    }

    private Offer convertToEntity(SaveOfferResource resource) {

        return mapper.map(resource, Offer.class);
    }

    private OfferResource convertToResource(Offer entity) {
        return mapper.map(entity, OfferResource.class);
    }

}
