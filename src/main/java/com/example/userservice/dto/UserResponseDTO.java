package com.example.userservice.dto;

import java.time.LocalDate;
import java.util.StringJoiner;

public class UserResponseDTO {

    private Long id;

    private String name;

    private String email;

    private LocalDate birthDate;

    private boolean isActive;

    public Long getId() {
        return id;
    }

    public UserResponseDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserResponseDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public UserResponseDTO setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public boolean getActive() {
        return isActive;
    }

    public UserResponseDTO setActive(boolean active) {
        isActive = active;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserResponseDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("email='" + email + "'")
                .add("birthDate=" + birthDate)
                .add("isActive=" + isActive)
                .toString();
    }
}
