package com.example.springApp.dao.postgres;

import com.example.springApp.model.Bird;
import com.example.springApp.model.Continent;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

public class BirdContinentManager {
    private final JdbcTemplate jdbcTemplate;

    public BirdContinentManager(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Continent> getBirdContinents(UUID id) {
        String query = "SELECT continent FROM bird_continent WHERE bird_id = ?";
        return jdbcTemplate.queryForList(query, Continent.class, id);
    }
    public void deleteContinents(UUID id) {
        String deleteBirdContinentQuery = "DELETE FROM bird_continent WHERE bird_id = ?";
        jdbcTemplate.update(deleteBirdContinentQuery, id);
    }

    public void updateContinents(Bird bird) {
        deleteContinents(bird.getId());
        insertContinents(bird);
    }

    public void insertContinents(Bird bird) {
        String insertBirdContinentQuery = "INSERT INTO bird_continent (bird_id, continent) VALUES (?, ?)";
        for (Continent continent : bird.getContinents()) {
            jdbcTemplate.update(insertBirdContinentQuery, bird.getId(), continent.ordinal());
        }
    }
}
