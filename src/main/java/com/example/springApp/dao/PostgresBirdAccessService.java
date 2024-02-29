package com.example.springApp.dao;

import com.example.springApp.model.Bird;
import com.example.springApp.model.ConservationStatus;
import com.example.springApp.model.Continent;
import com.example.springApp.model.Diet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PostgresBirdAccessService implements BirdDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresBirdAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Bird> getAllBirds() {
        String query = "SELECT * FROM bird";
        return jdbcTemplate.query(query, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            List<Continent> continents = getBirdContinents(id);
            List<String> colors = getBirdColors(id);
            return new Bird(
                    id,
                    resultSet.getString("name"),
                    resultSet.getString("latinname"),
                    continents,
                    resultSet.getInt("wingspancm"),
                    ConservationStatus.valueOf(resultSet.getString("conservationstatus")),
                    Diet.valueOf(resultSet.getString("diet")),
                    colors,
                    resultSet.getString("imagesrc")
                    );
        });
    }

    private List<Continent> getBirdContinents(UUID id) {
        String query = "SELECT continent FROM bird_continent WHERE bird_id = ?";
        return jdbcTemplate.queryForList(query, Continent.class, id);
    }

    private List<String> getBirdColors(UUID id) {
        String query = "SELECT color FROM bird_color WHERE bird_id = ?";
        return jdbcTemplate.queryForList(query, String.class, id);
    }

    @Override
    public Optional<Bird> getBirdById(UUID id) {
        String query = "SELECT * FROM bird WHERE id = ?";
        Bird bird = jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, i) -> {
            List<Continent> continents = getBirdContinents(id);
            List<String> colors = getBirdColors(id);
            return new Bird(
                    id,
                    resultSet.getString("name"),
                    resultSet.getString("latinname"),
                    continents,
                    resultSet.getInt("wingspancm"),
                    ConservationStatus.valueOf(resultSet.getString("conservationstatus")),
                    Diet.valueOf(resultSet.getString("diet")),
                    colors,
                    resultSet.getString("imagesrc")
            );
        });
        return Optional.ofNullable(bird);
    }

    @Override
    public int insertBird(UUID id, Bird bird) {
        String birdInsertQuery = "INSERT INTO bird (id, name, latinname, wingspancm, conservationstatus, diet, imagesrc) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(birdInsertQuery,
                id,
                bird.getName(),
                bird.getLatinName(),
                bird.getWingspanCm(),
                bird.getConservationStatus().name(),
                bird.getDiet().name(),
                bird.getImageSrc()
        );

        // Insert into bird_continent table for each continent
        String birdContinentInsertQuery = "INSERT INTO bird_continent (bird_id, continent) VALUES (?, ?)";
        for (Continent continent : bird.getContinents()) {
            jdbcTemplate.update(birdContinentInsertQuery, id, continent.ordinal());
        }

        // Insert into bird_color table for each color
        String birdColorInsertQuery = "INSERT INTO bird_color (bird_id, color) VALUES (?, ?)";
        for (String color : bird.getColors()) {
            jdbcTemplate.update(birdColorInsertQuery, id, color);
        }

        return 1;
    }

    @Override
    public int deleteBird(UUID id) {
        String birdContinentDeleteQuery = "DELETE FROM bird_continent WHERE bird_id = ?";
        jdbcTemplate.update(birdContinentDeleteQuery, id);

        String birdColorDeleteQuery = "DELETE FROM bird_color WHERE bird_id = ?";
        jdbcTemplate.update(birdColorDeleteQuery, id);

        String birdDeleteQuery = "DELETE FROM bird WHERE id = ?";
        return jdbcTemplate.update(birdDeleteQuery, id);
    }

    @Override
    public int updateBird(Bird bird) {
        String birdUpdateQuery = "UPDATE bird SET name = ?, latinname = ?, wingspancm = ?, " +
                "conservationStatus = ?, diet = ?, imageSrc = ? WHERE id = ?";
        int birdUpdateResult = jdbcTemplate.update(birdUpdateQuery,
                bird.getName(),
                bird.getLatinName(),
                bird.getWingspanCm(),
                bird.getConservationStatus().name(),
                bird.getDiet().name(),
                bird.getImageSrc(),
                bird.getId()
        );

        // Delete existing entries in Bird_Continent table
        String deleteBirdContinentQuery = "DELETE FROM bird_continent WHERE bird_id = ?";
        jdbcTemplate.update(deleteBirdContinentQuery, bird.getId());

        // Insert new entries into Bird_Continent table
        String insertBirdContinentQuery = "INSERT INTO bird_continent (bird_id, continent) VALUES (?, ?)";
        for (Continent continent : bird.getContinents()) {
            jdbcTemplate.update(insertBirdContinentQuery, bird.getId(), continent.ordinal());
        }

        // Delete existing entries in Bird_Color table
        String deleteBirdColorQuery = "DELETE FROM bird_color WHERE bird_id = ?";
        jdbcTemplate.update(deleteBirdColorQuery, bird.getId());

        // Insert new entries into Bird_Color table
        String insertBirdColorQuery = "INSERT INTO bird_color (bird_id, color) VALUES (?, ?)";
        for (String color : bird.getColors()) {
            jdbcTemplate.update(insertBirdColorQuery, bird.getId(), color);
        }

        // Return the total number of rows affected
        return birdUpdateResult;
    }
}
