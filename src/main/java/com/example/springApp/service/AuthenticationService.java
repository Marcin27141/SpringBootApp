package com.example.springApp.service;

import com.example.springApp.dao.postgres.jpa.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean authenticate(String username, String password) {
        var user = userRepository.findByUsername(username);
        return user.isPresent() && user.get().getPassword().equals(passwordEncoder.encode(password));
    }
}
