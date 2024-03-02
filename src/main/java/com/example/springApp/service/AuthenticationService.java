package com.example.springApp.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final String VALID_USERNAME = "admin";
    private final String VALID_PASSWORD = "P@ssw0rd";
    public boolean authenticate(String username, String password) {
        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }
}
