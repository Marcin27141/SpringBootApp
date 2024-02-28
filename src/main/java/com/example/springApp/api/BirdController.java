package com.example.springApp.api;

import com.example.springApp.model.Bird;
import com.example.springApp.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/bird")
@RestController
public class BirdController {
    private final BirdService birdService;

    @Autowired
    public BirdController(BirdService birdService) {
        this.birdService = birdService;
    }

    @PostMapping
    public void addBird(@RequestBody Bird bird) {
        birdService.addBird(bird);
    }

    @GetMapping
    public List<Bird> getAllBirds() {
        return birdService.getAllBirds();
    }
}
