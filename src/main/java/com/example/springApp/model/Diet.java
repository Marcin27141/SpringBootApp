package com.example.springApp.model;

public enum Diet {
    HERBIVORES,
    CARNIVOROUS,
    SCAVENGER,
    OMNIVORES;

    public String getName() {
        switch (this) {
            case HERBIVORES -> {
                return "Herbivores";
            }
            case CARNIVOROUS -> {
                return "Carnivorous";
            }
            case SCAVENGER -> {
                return "Scavenger";
            }
            case OMNIVORES -> {
                return "Omnivores";
            }
        }
        return "Unknown";
    }
}
