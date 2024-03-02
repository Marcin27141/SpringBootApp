package com.example.springApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class Bird {
    private UUID id;
    private String name;
    private String latinName;
    private List<Continent> continents;
    private int wingspanCm;
    private ConservationStatus conservationStatus;
    private Diet diet;
    private List<String> colors;
    private String imageSrc;
    private String article;
    private String trivia;

    public Bird(
            @JsonProperty("id") UUID id,
            @JsonProperty("name") String name,
            @JsonProperty("latinName") String latinName,
            @JsonProperty("continents") List<Continent> continents,
            @JsonProperty("wingspanCm") int wingspanCm,
            @JsonProperty("conservationStatus") ConservationStatus conservationStatus,
            @JsonProperty("diet") Diet diet,
            @JsonProperty("colors") List<String> colors,
            @JsonProperty("imageSrc") String imageSrc,
            @JsonProperty("trivia") String trivia,
            @JsonProperty("article") String article
    ) {
        this.id = id;
        this.name = name;
        this.latinName = latinName;
        this.continents = continents;
        this.wingspanCm = wingspanCm;
        this.conservationStatus = conservationStatus;
        this.diet = diet;
        this.colors = colors;
        this.imageSrc = imageSrc;
        this.trivia = trivia;
        this.article = article;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLatinName() {
        return latinName;
    }

    public List<Continent> getContinents() {
        return continents;
    }

    public int getWingspanCm() {
        return wingspanCm;
    }

    public ConservationStatus getConservationStatus() {
        return conservationStatus;
    }

    public Diet getDiet() {
        return diet;
    }

    public List<String> getColors() {
        return colors;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getTrivia() {
        return trivia;
    }

    public void setTrivia(String trivia) {
        this.trivia = trivia;
    }
}
