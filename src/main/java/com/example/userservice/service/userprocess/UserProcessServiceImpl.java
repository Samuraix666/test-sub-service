package com.example.userservice.service.userprocess;

import com.example.userservice.domain.User;
import com.example.userservice.dto.UserResponseDTO;
import com.example.userservice.repository.service.subscription.SubscriptionService;
import com.example.userservice.repository.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProcessServiceImpl implements UserProcessService {

    private final UserService userService;

    private final SubscriptionService subscriptionService;

    public UserProcessServiceImpl(
            UserService userService, SubscriptionService subscriptionService
    ) {
        this.userService = userService;
        this.subscriptionService = subscriptionService;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userService.findAll().stream()
                .map(this::mappingResponse)
                .toList();
    }

    @Override
    public void saveAndUpdateUser(UserResponseDTO response) {
        User user = new User()
                .setBirthDate(response.getBirthDate())
                .setId(response.getId())
                .setName(response.getName())
                .setEmail(response.getEmail())
                .setActive(response.getActive());

        userService.save(user);
    }

    private UserResponseDTO mappingResponse(User user) {
        return new UserResponseDTO()
                .setBirthDate(user.getBirthDate())
                .setId(user.getId())
                .setEmail(user.getEmail())
                .setName(user.getName());

    }


}
