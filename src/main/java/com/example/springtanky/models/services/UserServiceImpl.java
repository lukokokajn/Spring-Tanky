package com.example.springtanky.models.services;

import com.example.springtanky.data.entities.UserEntity;
import com.example.springtanky.data.repositories.UserRepository;
import com.example.springtanky.models.dto.UserDTO;
import com.example.springtanky.models.exeptions.DuplicateEmailException;
import com.example.springtanky.models.exeptions.PasswordsDoNotEqualException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void create(UserDTO user, boolean isAdmin) {
        if (!user.getPassword().equals(user.getConfirmPassword()))
            throw new PasswordsDoNotEqualException();

        UserEntity userEntity = new UserEntity();

        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));

        try {
            usersRepository.save(userEntity);
        } catch (DataIntegrityViolationException e) {
            Optional<UserEntity> emailEntry = usersRepository.findByEmail(user.getEmail());
            if (emailEntry.isPresent()) {
                throw new DuplicateEmailException();
            }
            }
    }

    @Override
    public UserEntity getUser(String email) {
        return usersRepository.findByEmail(email).get();

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username, " + username + " not found"));
    }
}