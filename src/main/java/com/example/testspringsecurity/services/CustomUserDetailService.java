package com.example.testspringsecurity.services;

import com.example.testspringsecurity.components.CustomUserDetailComponent;
import com.example.testspringsecurity.entities.User;
import com.example.testspringsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        System.out.println("testtesttest");
        System.out.println(optionalUser.isPresent());
        if(!optionalUser.isPresent()) {
            throw new UsernameNotFoundException("User not found.");
        }
        else {
            System.out.println("xxx");
            System.out.println(optionalUser.get().getUsername());
            return new CustomUserDetailComponent(optionalUser.get());
        }
    }

}
