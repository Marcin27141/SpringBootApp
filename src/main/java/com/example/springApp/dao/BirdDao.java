package com.example.springApp.dao;

import com.example.springApp.model.Bird;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BirdDao {
    List<Bird> getAllBirds();
    Optional<Bird> getBirdById(UUID id);
    int insertBird(UUID id, Bird bird);
    default int insertBird(Bird bird) {
        UUID id = UUID.randomUUID();
        return insertBird(id, bird);
    }
    int deleteBird(UUID id);
    int updateBird(Bird bird);
}
