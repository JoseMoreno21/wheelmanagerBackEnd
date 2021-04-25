package com.example.wheelmanager.domain.service;

import com.example.wheelmanager.domain.model.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface SubscriptionService {
    Page<Subscription> getAllSubscriptions(Pageable pageable);
    Subscription getSubscriptionById(Long subscriptionId);
    Subscription createSubscription(Subscription subscriptionId);
    Subscription updateSubscription(Long subscriptionId, Subscription messageRequest);
    ResponseEntity<?> deleteSubscription(Long subscriptionId);
}
