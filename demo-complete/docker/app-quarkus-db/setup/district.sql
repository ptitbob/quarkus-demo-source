create temp table district_temp (
  region varchar(2),
  departement varchar(3),
  cheflieu_city_insee varchar(6),
  type_nom bigint,
  nom_maj varchar(70),
  nom_min varchar(70)
);

COPY district_temp FROM '/data/depts2018.csv' DELIMITER ';' CSV;

insert into district(region, departement, cheflieu_city_insee, type_nom, nom_maj, nom_min)
  select region, departement, cheflieu_city_insee, type_nom, nom_maj, nom_min from district_temp;
