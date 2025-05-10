package com.example.userservice.service.subscriptionprocess;

import com.example.userservice.domain.Subscription;
import com.example.userservice.domain.User;
import com.example.userservice.dto.SubscriptionRequestDTO;
import com.example.userservice.dto.SubscriptionResponseDTO;
import com.example.userservice.repository.service.subscription.SubscriptionService;
import com.example.userservice.repository.service.user.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class SubscriptionProcessServiceImpl implements SubscriptionProcessService {

    private final UserService userService;

    private final SubscriptionService subscriptionService;

    public SubscriptionProcessServiceImpl(
            UserService userService, SubscriptionService subscriptionService
    ) {
        this.userService = userService;
        this.subscriptionService = subscriptionService;
    }

    @Override
    @Transactional
    public void createSubscription(SubscriptionRequestDTO request) {
        User user = userService.getById(request.getUserId());
        createForUser(user, request);
    }

    @Override
    public List<SubscriptionResponseDTO> getSubscriptionsByUserId(Long userId) {
        return subscriptionService.findByUserId(userId).stream()
                .map(this::mappingSub)
                .toList();
    }

    @Override
    public void deactivateSubscription(Long subscriptionId) {
        Subscription subscription = subscriptionService.findById(subscriptionId);
        subscription.setActive(false);
        subscriptionService.save(subscription);
    }

    @Override
    public List<String> getTop3SubscriptionNames() {
        List<Subscription> allSubscriptions = subscriptionService.findAll();

        Map<String, Long> countByServiceName = allSubscriptions.stream()
                .collect(Collectors.groupingBy(
                        Subscription::getServiceName,
                        Collectors.counting()
                ));

        return countByServiceName.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

        private void createForUser(User user, SubscriptionRequestDTO request) {
        Subscription subscription = new Subscription()
                .setUser(user)
                .setServiceName(request.getServiceName())
                .setStartDate(request.getStartDate())
                .setEndDate(request.getEndDate())
                .setActive(true)
                .setMonthlyRepayment(request.getMonthlyRepayment());
        subscriptionService.save(subscription);
    }

    private SubscriptionResponseDTO mappingSub(Subscription subscription) {
        return new SubscriptionResponseDTO()
                .setActive(subscription.getActive())
                .setEndDate(subscription.getEndDate())
                .setServiceName(subscription.getServiceName())
                .setStartDate(subscription.getStartDate())
                .setMonthlyPayment(subscription.getMonthlyRepayment());
    }


}
