package com.example.springApp.dao.postgres;

import com.example.springApp.model.Bird;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.UUID;

public class BirdColorManager {
    private final JdbcTemplate jdbcTemplate;

    public BirdColorManager(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getBirdColors(UUID id) {
        String query = "SELECT color FROM bird_color WHERE bird_id = ?";
        return jdbcTemplate.queryForList(query, String.class, id);
    }
    public void deleteColors(UUID id) {
        String deleteBirdColorQuery = "DELETE FROM bird_color WHERE bird_id = ?";
        jdbcTemplate.update(deleteBirdColorQuery, id);
    }

    public void updateColors(Bird bird) {
        deleteColors(bird.getId());
        insertColors(bird);
    }

    public void insertColors(Bird bird) {
        String insertBirdColorQuery = "INSERT INTO bird_color (bird_id, color) VALUES (?, ?)";
        for (String color : bird.getColors()) {
            jdbcTemplate.update(insertBirdColorQuery, bird.getId(), color);
        }
    }
}
