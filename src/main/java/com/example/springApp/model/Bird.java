package com.example.springApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.util.List;
import java.util.UUID;

public class Bird {
    private UUID id;
    private String name;
    private String latinName;
    private List<Continent> continents;
    @Positive(message = "Wingspan must be a positive number")
    private int wingspanCm;
    private ConservationStatus conservationStatus;
    private Diet diet;
    private List<String> colors;
    @URL(message = "Please provide a valid URL")
    private String imageSrc;
    @URL(message = "Please provide a valid URL")
    private String article;
    @Size(max = 1024, message = "Max length is 1024 characters")
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

    public Bird() {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public void setContinents(List<Continent> continents) {
        this.continents = continents;
    }

    public void setWingspanCm(int wingspanCm) {
        this.wingspanCm = wingspanCm;
    }

    public void setConservationStatus(ConservationStatus conservationStatus) {
        this.conservationStatus = conservationStatus;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
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
