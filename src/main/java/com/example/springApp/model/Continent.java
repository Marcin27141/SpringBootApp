package com.example.springApp.model;

public enum Continent {
    EUROPE,
    ASIA,
    AFRICA,
    NORTH_AMERICA,
    SOUTH_AMERICA,
    AUSTRALIA,
    ANTARCTICA;

    public String getName() {
        switch (this) {
            case EUROPE -> {
                return "Europe";
            }
            case ASIA -> {
                return "Asia";
            }
            case AFRICA -> {
                return "Africa";
            }
            case NORTH_AMERICA -> {
                return "North America";
            }
            case SOUTH_AMERICA -> {
                return "South America";
            }
            case AUSTRALIA -> {
                return "Australia";
            }
            case ANTARCTICA -> {
                return "Antarctica";
            }
        }
        return "Unknown";
    }
}
