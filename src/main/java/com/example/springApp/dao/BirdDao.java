package com.example.springApp.dao;

import com.example.springApp.model.Bird;

import java.util.List;
import java.util.UUID;

public interface BirdDao {
    List<Bird> getAllBirds();
    int insertBird(UUID id, Bird bird);
    default int insertBird(Bird bird) {
        UUID id = UUID.randomUUID();
        return insertBird(id, bird);
    }
}
