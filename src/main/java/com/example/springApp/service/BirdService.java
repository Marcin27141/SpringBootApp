package com.example.springApp.service;

import com.example.springApp.dao.BirdDao;
import com.example.springApp.model.Bird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BirdService {
    private final BirdDao birdDao;

    @Autowired
    public BirdService(@Qualifier("inMemoryDao") BirdDao birdDao) {
        this.birdDao = birdDao;
    }

    public int addBird(Bird bird) {
        return birdDao.insertBird(bird);
    }

    public List<Bird> getAllBirds() {
        return birdDao.getAllBirds();
    }
}
