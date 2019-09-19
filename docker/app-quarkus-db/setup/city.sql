create temp table city_temp (
  cdc bigint,
  cheflieu bigint,
  region varchar(2),
  departement varchar(3),
  code varchar(3),
  code_ar varchar(1),
  code_canton varchar(2),
  type_nom bigint,
  art_maj varchar(5),
  nom_maj varchar(70),
  art_min varchar(5),
  nom_min varchar(70)
);


COPY city_temp FROM '/data/comsimp2018.csv' DELIMITER ';' CSV;

insert into city(insee, cdc, cheflieu, region, departement, code, code_ar, code_canton, type_nom, art_maj, nom_maj, art_min, nom_min)
  select departement || code, cdc, cheflieu, region, departement, code, code_ar, code_canton, type_nom, art_maj, nom_maj, art_min, nom_min from city_temp;
