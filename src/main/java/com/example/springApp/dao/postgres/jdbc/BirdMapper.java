package com.example.springApp.dao.postgres.jdbc;

import com.example.springApp.model.Bird;
import com.example.springApp.model.ConservationStatus;
import com.example.springApp.model.Continent;
import com.example.springApp.model.Diet;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BirdMapper implements RowMapper<Bird> {

    private final BirdContinentManager continentManager;
    private final BirdColorManager colorManager;

    public BirdMapper(BirdContinentManager continentManager, BirdColorManager colorManager) {
        this.continentManager = continentManager;
        this.colorManager = colorManager;
    }

    @Override
    public Bird mapRow(ResultSet rs, int rowNum) throws SQLException {
        UUID id = UUID.fromString(rs.getString("id"));
        List<Continent> continents = continentManager.getBirdContinents(id);
        List<String> colors = colorManager.getBirdColors(id);
        return new Bird(
                id,
                rs.getString("name"),
                rs.getString("latinname"),
                continents,
                rs.getInt("wingspancm"),
                ConservationStatus.values()[rs.getInt("conservationstatus")],
                Diet.values()[rs.getInt("diet")],
                colors,
                rs.getString("imagesrc"),
                rs.getString("trivia"),
                rs.getString("article")
        );
    }

    public ArrayList<Object> getBirdColumnsWithoutId(Bird bird) {
        return new ArrayList<>(List.of(
                bird.getName(),
                bird.getLatinName(),
                bird.getWingspanCm(),
                bird.getConservationStatus().ordinal(),
                bird.getDiet().ordinal(),
                bird.getImageSrc(),
                bird.getTrivia(),
                bird.getArticle()
        ));
    }
}
