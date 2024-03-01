package com.example.springApp.dao.postgres.jpa;

import com.example.springApp.dao.BirdDao;
import com.example.springApp.model.Bird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
interface BirdRepository extends JpaRepository<BirdEntity, UUID> { }
@Repository("postgres_jpa")
public class PostgresHibernateBirdAccessService implements BirdDao {
    private final BirdRepository birdRepository;

    @Autowired
    public PostgresHibernateBirdAccessService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public List<Bird> getAllBirds() {
        return birdRepository.findAll().stream().map(BirdEntity::ConvertToBird).toList();
    }

    @Override
    public Optional<Bird> getBirdById(UUID id) {
        return birdRepository.findById(id).map(BirdEntity::ConvertToBird);
    }

    @Override
    public int insertBird(UUID id, Bird bird) {
        birdRepository.save(BirdEntity.ConvertFromBird(bird));
        return 1;
    }

    @Override
    public int deleteBird(UUID id) {
        var toDelete = birdRepository.findById(id);
        if (toDelete.isPresent()) {
            birdRepository.delete(toDelete.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updateBird(Bird bird) {
        var toUpdate = birdRepository.findById(bird.getId());
        if (toUpdate.isPresent()) {
            var birdToUpdate = updateBirdEntity(bird, toUpdate.get());
            birdRepository.save(birdToUpdate);
            return 1;
        }

        return 0;
    }

    private static BirdEntity updateBirdEntity(Bird bird, BirdEntity birdToUpdate) {
        birdToUpdate.setName(bird.getName());
        birdToUpdate.setLatinname(bird.getLatinName());
        birdToUpdate.setWingspancm(bird.getWingspanCm());
        birdToUpdate.setDiet(bird.getDiet());
        birdToUpdate.setConservationstatus(bird.getConservationStatus());
        birdToUpdate.setImagesrc(bird.getImageSrc());
        birdToUpdate.setContinents(bird.getContinents());
        birdToUpdate.setColors(bird.getColors());
        return birdToUpdate;
    }
}
