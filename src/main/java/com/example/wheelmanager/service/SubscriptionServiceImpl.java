package com.example.wheelmanager.service;

import com.example.wheelmanager.domain.model.Subscription;
import com.example.wheelmanager.domain.repository.SubscriptionRepository;
import com.example.wheelmanager.domain.service.SubscriptionService;
import com.example.wheelmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;


    @Override
    public Page<Subscription> getAllSubscriptions(Pageable pageable) {
        return subscriptionRepository.findAll(pageable);
    }

    @Override
    public Subscription getSubscriptionById(Long subscriptionId) {
        return subscriptionRepository.findById(subscriptionId)
                .orElseThrow(()->new ResourceNotFoundException(
                        "Subscription","Id", subscriptionId));
    }

    @Override
    public Subscription createSubscription(Subscription subscriptionId) {

        return subscriptionRepository.save(subscriptionId);
    }

    @Override
    public Subscription updateSubscription(Long subscriptionId, Subscription subscriptionRequest) {
        Subscription subscription=subscriptionRepository.findById(subscriptionId)
                .orElseThrow(()->new ResourceNotFoundException(
                        "Subscription","Id", subscriptionId));
        return subscriptionRepository.save(
                subscription.setDescriptions(subscriptionRequest.getDescriptions())
                .setPrice(subscriptionRequest.getPrice()));
    }

    @Override
    public ResponseEntity<?> deleteSubscription(Long subscriptionId) {
        Subscription subscription=subscriptionRepository.findById(subscriptionId)
                .orElseThrow(()->new ResourceNotFoundException(
                        "Subscription","Id", subscriptionId));
        subscriptionRepository.delete(subscription);
        return ResponseEntity.ok().build();
    }
}
