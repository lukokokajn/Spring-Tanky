package com.example.springtanky.models.services;

import com.example.springtanky.data.entities.UserEntity;
import com.example.springtanky.models.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void create(UserDTO user, boolean isAdmin);
    UserEntity getUser(String email);
}
