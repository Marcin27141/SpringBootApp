package com.example.springApp.dao.postgres.jdbc;

import com.example.springApp.dao.BirdDao;
import com.example.springApp.model.Bird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PostgresBirdAccessService implements BirdDao {
    private final JdbcTemplate jdbcTemplate;
    private final BirdMapper birdMapper;
    private final BirdColorManager colorManager;
    private final BirdContinentManager continentManager;

    @Autowired
    public PostgresBirdAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        colorManager = new BirdColorManager(jdbcTemplate);
        continentManager = new BirdContinentManager(jdbcTemplate);
        birdMapper = new BirdMapper(continentManager, colorManager);
    }

    @Override
    public List<Bird> getAllBirds() {
        String query = "SELECT * FROM bird";
        return jdbcTemplate.query(query, birdMapper);
    }

    @Override
    public Optional<Bird> getBirdById(UUID id) {
        String query = "SELECT * FROM bird WHERE id = ?";
        List<Bird> birdList = jdbcTemplate.query(query, birdMapper, id);
        return birdList.isEmpty() ? Optional.empty() : Optional.of(birdList.get(0));
    }

    @Override
    public Page<Bird> getBirdsPage(Pageable pageable) {
        return Page.empty();
    }

    @Override
    public int insertBird(UUID id, Bird bird) {
        String birdInsertQuery = "INSERT INTO bird (id, name, latinname, wingspancm, conservationstatus, diet, imagesrc, trivia, article) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        var args = birdMapper.getBirdColumnsWithoutId(bird);
        args.add(0, id);
        jdbcTemplate.update(birdInsertQuery, args.toArray());

        continentManager.insertContinents(bird);
        colorManager.insertColors(bird);

        return 1;
    }

    @Override
    public int deleteBird(UUID id) {
        continentManager.deleteContinents(id);
        colorManager.deleteColors(id);
        String birdDeleteQuery = "DELETE FROM bird WHERE id = ?";
        return jdbcTemplate.update(birdDeleteQuery, id);
    }

    @Override
    public int updateBird(Bird bird) {
        String birdUpdateQuery = "UPDATE bird SET name = ?, latinname = ?, wingspancm = ?, " +
                "conservationStatus = ?, diet = ?, imageSrc = ?, trivia = ?, article = ? WHERE id = ?";
        var args = birdMapper.getBirdColumnsWithoutId(bird);
        args.add(args.size(), bird.getId());
        int birdUpdateResult = jdbcTemplate.update(birdUpdateQuery, args.toArray());

        continentManager.updateContinents(bird);
        colorManager.updateColors(bird);

        return birdUpdateResult;
    }
}
