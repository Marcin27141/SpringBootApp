CREATE TYPE Continent AS ENUM ('NorthAmerica', 'SouthAmerica', 'Europe', 'Asia', 'Africa', 'Australia', 'Antarctica');

CREATE TABLE Bird (
  id UUID PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  latinName VARCHAR(255) NOT NULL,
  wingspanCm INT NOT NULL,
  conservationStatus VARCHAR(50) NOT NULL,
  diet VARCHAR(50) NOT NULL,
  imageSrc VARCHAR(255)
);

CREATE TABLE Bird_Continent (
    bird_id UUID REFERENCES Bird(id),
    continent Continent,
    PRIMARY KEY (bird_id, continent)
);

CREATE TABLE Bird_Color (
    bird_id UUID REFERENCES Bird(id),
    color VARCHAR(50),
    PRIMARY KEY (bird_id, color)
);