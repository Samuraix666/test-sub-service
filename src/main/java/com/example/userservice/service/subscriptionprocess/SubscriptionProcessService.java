package com.example.userservice.service.subscriptionprocess;

import com.example.userservice.dto.SubscriptionRequestDTO;
import com.example.userservice.dto.SubscriptionResponseDTO;

import java.util.List;

public interface SubscriptionProcessService {

    void createSubscription (SubscriptionRequestDTO request);

    List<SubscriptionResponseDTO> getSubscriptionsByUserId(Long userId);

    void deactivateSubscription(Long subscriptionId);

    List<String> getTop3SubscriptionNames();
}
