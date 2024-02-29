DROP TABLE Bird_Continent;
CREATE TABLE Bird_Continent (
    bird_id UUID REFERENCES Bird(id),
    continent INT,
    PRIMARY KEY (bird_id, continent)
);