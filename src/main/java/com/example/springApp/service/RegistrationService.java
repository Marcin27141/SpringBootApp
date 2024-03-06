package com.example.springApp.service;

import com.example.springApp.dao.postgres.jpa.UserRepository;
import com.example.springApp.model.RegistrationUser;
import com.example.springApp.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.Console;

@Service
public class RegistrationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegistrationUser registrationUser) {
        if(checkIfUserExist(registrationUser.getEmail())){
            throw new IllegalStateException("User already exists for this email");
        }
        User newUser = new User();
        BeanUtils.copyProperties(registrationUser, newUser);
        encodePassword(newUser, registrationUser);
        userRepository.save(newUser);
    }

    public boolean checkIfUserExist(String email) {
        return false;//userRepository.findByEmail(email).isPresent();
    }

    private void encodePassword(User user, RegistrationUser registrationUser){
        user.setPassword(passwordEncoder.encode(registrationUser.getPassword()));
    }
}
