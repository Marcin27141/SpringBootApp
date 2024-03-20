package com.example.springApp.exceptions;

public class PasswordsNotEqualException extends Exception {
    public PasswordsNotEqualException(String message) {
        super(message);
    }
}
