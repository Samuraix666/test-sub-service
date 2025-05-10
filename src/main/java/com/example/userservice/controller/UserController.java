package com.example.userservice.controller;

import com.example.userservice.dto.SubscriptionRequestDTO;
import com.example.userservice.dto.SubscriptionResponseDTO;
import com.example.userservice.dto.UserResponseDTO;
import com.example.userservice.service.subscriptionprocess.SubscriptionProcessService;
import com.example.userservice.service.userprocess.UserProcessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final SubscriptionProcessService subscriptionProcessService;

    private final UserProcessService userProcessService;

    public UserController(
            SubscriptionProcessService subscriptionProcessService,
            UserProcessService userProcessService
    ) {
        this.subscriptionProcessService = subscriptionProcessService;
        this.userProcessService = userProcessService;
    }

    @PostMapping("/save-and-update")
    public ResponseEntity<Void> save(
            @RequestBody UserResponseDTO user
    ) {
        userProcessService.saveAndUpdateUser(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/subscriptions")
    public ResponseEntity<Void> createSubscription(@RequestBody SubscriptionRequestDTO request) {
        subscriptionProcessService.createSubscription(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/get-all-users")
    public List<UserResponseDTO> getAll() {
        return userProcessService.getAllUsers();
    }

    @GetMapping("/{userId}/subscriptions")
    public List<SubscriptionResponseDTO> getUserSubscriptions(@PathVariable Long userId) {
        return subscriptionProcessService.getSubscriptionsByUserId(userId);
    }

    @PostMapping("/subscriptions/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        subscriptionProcessService.deactivateSubscription(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/subscriptions/top")
    public List<String> getTopSubscriptionNames() {
        return subscriptionProcessService.getTop3SubscriptionNames();
    }


}
