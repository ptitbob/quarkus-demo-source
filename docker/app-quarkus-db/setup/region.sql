create temp table region_temp (
  region varchar(2),
  cheflieu_city_insee varchar(6),
  type_nom bigint,
  nom_maj varchar(70),
  nom_min varchar(70)
);

COPY region_temp FROM '/data/reg2018.csv' DELIMITER ';' CSV;

insert into region(region, cheflieu_city_insee, type_nom, nom_maj, nom_min)
  select region, cheflieu_city_insee, type_nom, nom_maj, nom_min from region_temp;

