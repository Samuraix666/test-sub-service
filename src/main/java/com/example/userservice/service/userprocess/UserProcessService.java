package com.example.userservice.service.userprocess;

import com.example.userservice.dto.UserResponseDTO;

import java.util.List;

public interface UserProcessService {

    List<UserResponseDTO> getAllUsers();

    void saveAndUpdateUser(UserResponseDTO response);
}
