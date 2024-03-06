package com.example.springApp.exceptions;

public class UsernameTakenException extends Exception {
    public UsernameTakenException(String message) {
        super(message);
    }
}
