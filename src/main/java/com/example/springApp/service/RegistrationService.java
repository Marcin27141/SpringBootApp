package com.example.springApp.service;

import com.example.springApp.dao.postgres.jpa.UserRepository;
import com.example.springApp.exceptions.EmailTakenException;
import com.example.springApp.exceptions.UsernameTakenException;
import com.example.springApp.model.RegistrationUser;
import com.example.springApp.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class RegistrationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Random random = new Random();

    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegistrationUser registrationUser) throws EmailTakenException, UsernameTakenException {
        if(checkIfEmailTaken(registrationUser.getEmail())){
            throw new EmailTakenException("User already exists for this email");
        }
        if(checkIfUsernameTaken(registrationUser.getUsername())){
            throw new UsernameTakenException("User already exists for this username");
        }
        User newUser = new User();
        BeanUtils.copyProperties(registrationUser, newUser);
        encodePassword(newUser, registrationUser);
        newUser.setId(random.nextLong());
        userRepository.save(newUser);
    }

    public boolean checkIfEmailTaken(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
    public boolean checkIfUsernameTaken(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    private void encodePassword(User user, RegistrationUser registrationUser){
        user.setPassword(passwordEncoder.encode(registrationUser.getPassword()));
    }
}
