package com.example.springApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.util.List;
import java.util.UUID;

public class DisplayBird {
    private UUID id;
    private String name;
    private String latinName;
    private List<String> continents;
    private int wingspanCm;
    private String conservationStatus;
    private String diet;
    private List<String> colors;
    private String imageSrc;
    private String article;
    private String trivia;

    public DisplayBird(Bird _bird) {
        this(
            _bird.getId(),
            _bird.getName(),
            _bird.getLatinName(),
            _bird.getContinents().stream().map(Continent::getName).toList(),
            _bird.getWingspanCm(),
            _bird.getConservationStatus().getName(),
            _bird.getDiet().getName(),
            _bird.getColors(),
            _bird.getImageSrc(),
            _bird.getArticle(),
            _bird.getTrivia()
        );
    }

    public DisplayBird(UUID id, String name, String latinName, List<String> continents, int wingspanCm, String conservationStatus, String diet, List<String> colors, String imageSrc, String article, String trivia) {
        this.id = id;
        this.name = name;
        this.latinName = latinName;
        this.continents = continents;
        this.wingspanCm = wingspanCm;
        this.conservationStatus = conservationStatus;
        this.diet = diet;
        this.colors = colors;
        this.imageSrc = imageSrc;
        this.article = article;
        this.trivia = trivia;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public List<String> getContinents() {
        return continents;
    }

    public void setContinents(List<String> continents) {
        this.continents = continents;
    }

    public int getWingspanCm() {
        return wingspanCm;
    }

    public void setWingspanCm(int wingspanCm) {
        this.wingspanCm = wingspanCm;
    }

    public String getConservationStatus() {
        return conservationStatus;
    }

    public void setConservationStatus(String conservationStatus) {
        this.conservationStatus = conservationStatus;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
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
