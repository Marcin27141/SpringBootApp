package com.example.springApp.dao.postgres.jpa;

import com.example.springApp.model.Bird;
import com.example.springApp.model.ConservationStatus;
import com.example.springApp.model.Continent;
import com.example.springApp.model.Diet;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "bird")
public class BirdEntity {
    @Id
    private UUID id;
    private String name;
    private String latinname;
    private int wingspancm;
    private ConservationStatus conservationstatus;
    private Diet diet;
    private String imagesrc;
    private String trivia;
    private String article;

    @ElementCollection
    @CollectionTable(
            name = "bird_color",
            joinColumns = @JoinColumn(name = "bird_id")
    )
    @Column(name = "color")
    private List<String> colors;

    @ElementCollection
    @CollectionTable(
            name = "bird_continent",
            joinColumns = @JoinColumn(name = "bird_id")
    )
    @Column(name = "continent")
    private List<Continent> continents;

    public BirdEntity() {
    }

    public BirdEntity(UUID id, String name, String latinname, int wingspancm, ConservationStatus conservationstatus, Diet diet, String imagesrc, String trivia, String article, List<String> colors, List<Continent> continents) {
        this.id = id;
        this.name = name;
        this.latinname = latinname;
        this.wingspancm = wingspancm;
        this.conservationstatus = conservationstatus;
        this.diet = diet;
        this.imagesrc = imagesrc;
        this.trivia = trivia;
        this.article = article;
        this.colors = colors;
        this.continents = continents;
    }

    public Bird ConvertToBird() {
        return new Bird(
                id,
                name,
                latinname,
                continents,
                wingspancm,
                conservationstatus,
                diet,
                colors,
                imagesrc,
                trivia,
                article
        );
    }

    public static BirdEntity ConvertFromBird(Bird bird) {
        return new BirdEntity(
                bird.getId(),
                bird.getName(),
                bird.getLatinName(),
                bird.getWingspanCm(),
                bird.getConservationStatus(),
                bird.getDiet(),
                bird.getImageSrc(),
                bird.getTrivia(),
                bird.getArticle(),
                bird.getColors(),
                bird.getContinents()
        );
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatinname(String latinname) {
        this.latinname = latinname;
    }

    public void setWingspancm(int wingspancm) {
        this.wingspancm = wingspancm;
    }

    public void setConservationstatus(ConservationStatus conservationstatus) {
        this.conservationstatus = conservationstatus;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public void setImagesrc(String imagesrc) {
        this.imagesrc = imagesrc;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public void setContinents(List<Continent> continents) {
        this.continents = continents;
    }

    public String getTrivia() {
        return trivia;
    }

    public void setTrivia(String trivia) {
        this.trivia = trivia;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
