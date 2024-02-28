package com.example.springApp.dao;

import com.example.springApp.model.Bird;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("inMemoryDao")
public class InMemoryBirdAccessService implements BirdDao {
    private static List<Bird> birds = new ArrayList<>();

    @Override
    public List<Bird> getAllBirds() {
        return birds;
    }

    @Override
    public int insertBird(UUID id, Bird bird) {
        bird.setId(id);
        birds.add(bird);
        return 1;
    }
}
