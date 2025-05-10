package com.example.userservice.repository.service.user;

import com.example.userservice.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User save(User user);

    User getById(Long id);

    List<User> findAll();
}
