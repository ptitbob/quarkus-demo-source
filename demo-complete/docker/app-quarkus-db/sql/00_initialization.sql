drop sequence if exists hibernate_sequence;

create sequence hibernate_sequence start 200 cache 10;

drop table if exists zipcode;
drop table if exists city;
drop table if exists district;
drop table if exists region;

drop sequence if exists zipcode_seq;
create sequence zipcode_seq;

create table zipcode (
  id bigint not null default nextval('zipcode_seq') primary key,
  city_insee varchar(30),
  nom varchar(255),
  code_postal varchar(50),
  ligne varchar(255)
);

drop sequence if exists city_seq;
create sequence city_seq;

create table city (
  id bigint not null default nextval('city_seq') primary key,
  insee varchar(6), -- code insee de la commune
  cdc bigint, -- CDC 	Découpage de la commune en cantons
  cheflieu bigint, -- CHEFLIEU 	Chef-lieu d'arrondissement, de département, de région ou bureau centralisateur de canton
  region varchar(2), -- REG 	Code région
  departement varchar(3), -- DEP 	Code département
  code varchar(3), -- COM 	Code commune
  code_ar varchar(1), -- AR 	Code arrondissement
  code_canton varchar(2), -- CT 	Code canton
  type_nom bigint, -- TNCC 	Type de nom en clair
  art_maj varchar(5), -- ARTMAJ 	Article (majuscules)
  nom_maj varchar(70), -- NCC 	Nom en clair (majuscules)
  art_min varchar(5), -- ARTMIN 	Article (typographie riche)
  nom_min varchar(70) -- NCCENR 	Nom en clair (typographie riche)
);

drop sequence if exists district_seq;
create sequence district_seq;

create table district (
  id bigint not null default nextval('district_seq') primary key,
  region varchar(2), -- Code région
  departement varchar(3), -- Code département
  cheflieu_city_insee varchar(6), -- code insee du chef lieu
  type_nom bigint,  -- Type de nom en clair
  nom_maj varchar(70), -- Nom en clair (majuscules)
  nom_min varchar(70) -- Nom en clair (typographie riche)
);

drop sequence if exists region_seq;
create sequence region_seq;

create table region (
  id bigint not null default nextval('region_seq') primary key,
  region varchar(2), -- Code région
  cheflieu_city_insee varchar(6), -- code insee du chef lieu
  type_nom bigint, -- Type de nom en clair
  nom_maj varchar(70), -- Nom en clair (majuscules)
  nom_min varchar(70) -- Nom en clair (typographie riche)
);

drop sequence if exists code_seq;
create sequence code_seq;

create table code (
  id bigint not null default nextval('code_seq') primary key,
  famille varchar(50) not null,
  code bigint not null,
  libelle varchar(100) not null
);

drop sequence if exists type_nom_sequence;
create sequence type_nom_sequence;

create table type_nom (
  id bigint not null default nextval('type_nom_sequence') primary key,
  type_nom bigint not null,
  uppercase boolean not null,
  article varchar(10),
  charniere varchar(10),
  commentaire varchar(100)
);
