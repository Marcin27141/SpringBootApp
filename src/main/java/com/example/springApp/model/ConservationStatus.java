package com.example.springApp.model;

import java.util.Arrays;

public enum ConservationStatus {
    LEAST_CONCERN,
    NEAR_THREATENED,
    VULNERABLE,
    ENDANGERED,
    CRITICALLY_ENDANGERED,
    EXTINCT;

    public String getName() {
        switch (this) {
            case LEAST_CONCERN -> {
                return "Least concern";
            }
            case NEAR_THREATENED -> {
                return "Near threatened";
            }
            case VULNERABLE -> {
                return "Vulnerable";
            }
            case ENDANGERED -> {
                return "Endangered";
            }
            case CRITICALLY_ENDANGERED -> {
                return "Critically endangered";
            }
            case EXTINCT -> {
                return "Extinct";
            }
        }
        return "Unknown";
    }
}
