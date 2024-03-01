package com.example.springApp.dao;

import com.example.springApp.model.Bird;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("inMemoryDao")
public class InMemoryBirdAccessService implements BirdDao {
    private static List<Bird> birds = new ArrayList<>();

    @Override
    public List<Bird> getAllBirds() {
        return birds;
    }

    @Override
    public Optional<Bird> getBirdById(UUID id) {
        return birds.stream()
                .filter(bird -> bird.getId().equals(id))
                .findFirst();
    }

    @Override
    public Page<Bird> getBirdsPage(Pageable pageable) {
        return Page.empty();
    }

    @Override
    public int insertBird(UUID id, Bird bird) {
        bird.setId(id);
        birds.add(bird);
        return 1;
    }

    @Override
    public int deleteBird(UUID id) {
        var bird = getBirdById(id);
        if (bird.isEmpty())
            return 0;
        birds.remove(bird.get());
        return 1;
    }

    @Override
    public int updateBird(Bird bird) {
        var existing = birds.stream().filter(b -> b.getId().equals(bird.getId())).findFirst();
        if (existing.isEmpty())
            return 0;
        birds.set(birds.indexOf(existing.get()), bird);
        return 1;
    }
}
