package com.example.testspringsecurity.services;

import com.example.testspringsecurity.entities.User;
import com.example.testspringsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

}
