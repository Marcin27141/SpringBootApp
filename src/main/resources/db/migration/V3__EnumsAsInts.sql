DROP TABLE Bird_Color;
DROP TABLE Bird_Continent;
DROP TABLE Bird;

CREATE TABLE Bird (
  id UUID PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  latinName VARCHAR(255) NOT NULL,
  wingspanCm INT NOT NULL,
  conservationStatus INT NOT NULL,
  diet INT NOT NULL,
  imageSrc VARCHAR(255)
);

CREATE TABLE Bird_Continent (
    bird_id UUID REFERENCES Bird(id),
    continent INT,
    PRIMARY KEY (bird_id, continent)
);

CREATE TABLE Bird_Color (
    bird_id UUID REFERENCES Bird(id),
    color VARCHAR(50),
    PRIMARY KEY (bird_id, color)
);