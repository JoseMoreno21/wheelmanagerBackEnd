package com.example.wheelmanager.service;

import com.example.wheelmanager.domain.model.Subscription;
import com.example.wheelmanager.domain.repository.SubscriptionRepository;
import com.example.wheelmanager.domain.repository.UserRepository;
import com.example.wheelmanager.domain.service.SubscriptionService;
import com.example.wheelmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private UserRepository userRepository;


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
    public Subscription createSubscription(Long userId, Subscription subscription) {

        return userRepository.findById(userId).map(user -> {
            subscription.setUser(user);
            return subscriptionRepository.save(subscription);
        }).orElseThrow(() -> new ResourceNotFoundException( "User", "Id", userId));
    }

    @Override
    public Subscription updateSubscription(Long userId,
                                           Long subscriptionId, Subscription subscriptionRequest) {
        if(!userRepository.existsById(userId))
            throw new ResourceNotFoundException("User" + "Id" + userId);

        Subscription subscription=subscriptionRepository.findById(subscriptionId)
                .orElseThrow(()->new ResourceNotFoundException(
                        "Subscription","Id", subscriptionId));
        return subscriptionRepository.save(
                subscription.setDescriptions(subscriptionRequest.getDescriptions())
                .setPrice(subscriptionRequest.getPrice()));
    }

    @Override
    public ResponseEntity<?> deleteSubscription(Long userId, Long subscriptionId) {
        return subscriptionRepository.findByIdAndUserId(subscriptionId, userId).map(subscription -> {
            subscriptionRepository.delete(subscription);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Message not found with Id " + subscriptionId + " and UserId " + userId));
    }
}
