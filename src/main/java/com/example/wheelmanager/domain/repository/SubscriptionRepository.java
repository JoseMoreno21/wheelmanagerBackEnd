package com.example.wheelmanager.domain.repository;

import com.example.wheelmanager.domain.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
}
