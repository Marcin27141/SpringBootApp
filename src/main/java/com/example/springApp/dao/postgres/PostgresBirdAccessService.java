package com.example.springApp.dao.postgres;

import com.example.springApp.dao.BirdDao;
import com.example.springApp.model.Bird;
import com.example.springApp.model.ConservationStatus;
import com.example.springApp.model.Continent;
import com.example.springApp.model.Diet;
import org.hibernate.annotations.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

//    private class BirdMapper implements RowMapper<Bird> {
//
//        @Override
//        public Bird mapRow(ResultSet rs, int rowNum) throws SQLException {
//            UUID id = UUID.fromString(rs.getString("id"));
//            List<Continent> continents = continentManager.getBirdContinents(id);
//            List<String> colors = colorManager.getBirdColors(id);
//            return new Bird(
//                    id,
//                    rs.getString("name"),
//                    rs.getString("latinname"),
//                    continents,
//                    rs.getInt("wingspancm"),
//                    ConservationStatus.valueOf(rs.getString("conservationstatus")),
//                    Diet.valueOf(rs.getString("diet")),
//                    colors,
//                    rs.getString("imagesrc")
//            );
//        }
//
//        public ArrayList<Object> getBirdColumnsWithoutId(Bird bird) {
//            return new ArrayList<>(List.of(
//                    bird.getName(),
//                    bird.getLatinName(),
//                    bird.getWingspanCm(),
//                    bird.getConservationStatus().name(),
//                    bird.getDiet().name(),
//                    bird.getImageSrc()
//            ));
//        }
//    }

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
    public int insertBird(UUID id, Bird bird) {
        String birdInsertQuery = "INSERT INTO bird (id, name, latinname, wingspancm, conservationstatus, diet, imagesrc) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
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
                "conservationStatus = ?, diet = ?, imageSrc = ? WHERE id = ?";
        var args = birdMapper.getBirdColumnsWithoutId(bird);
        args.add(args.size(), bird.getId());
        int birdUpdateResult = jdbcTemplate.update(birdUpdateQuery, args.toArray());

        continentManager.updateContinents(bird);
        colorManager.updateColors(bird);

        return birdUpdateResult;
    }
}
