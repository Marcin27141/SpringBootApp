package com.example.springApp.api;

import com.example.springApp.model.Bird;
import com.example.springApp.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/bird")
@RestController
public class BirdApiController {
    private final BirdService birdService;

    @Autowired
    public BirdApiController(BirdService birdService) {
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

    @GetMapping(path = "chunk")
    public Page<Bird> getBirdsPage(Pageable pageable) {
        return birdService.getBirdsPage(pageable);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Bird> getBirdById(@PathVariable("id") UUID id) {
        return birdService.getBirdById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteBird(@PathVariable("id") UUID id) {
        return birdService.deleteBird(id) == 0 ?
                ResponseEntity.notFound().build() :
                ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateBird(@RequestBody Bird bird) {
        return birdService.updateBird(bird) == 0 ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok().build();

    }
}
