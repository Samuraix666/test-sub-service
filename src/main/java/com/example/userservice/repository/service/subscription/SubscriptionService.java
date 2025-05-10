package com.example.userservice.repository.service.subscription;

import com.example.userservice.domain.Subscription;

import java.util.List;

public interface SubscriptionService {

    Subscription save(Subscription subscription);

    List<Subscription> findByUserId(Long userId);

    Subscription findById(Long id);

    List<Subscription> findAll();
}
