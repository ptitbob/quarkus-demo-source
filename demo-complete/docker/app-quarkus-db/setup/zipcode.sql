create temp table zipcode_temp (
  insee varchar(30),
  nom varchar(255),
  code_postal varchar(50),
  libelle varchar(255),
  ligne varchar(255),
  coordonnees_gps varchar(100)
);

COPY zipcode_temp FROM '/data/cities.csv' DELIMITER ';' CSV;

insert into zipcode(city_insee, nom, code_postal, ligne)
  select insee, nom, code_postal, ligne from zipcode_temp;

