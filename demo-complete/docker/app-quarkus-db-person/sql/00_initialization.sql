drop table if exists person;
drop sequence if exists person_sequence;
drop sequence if exists hibernate_sequence;

create sequence person_sequence start 100 cache 10;
create sequence hibernate_sequence start 200 cache 10;

create table person (
  id bigint not null default nextval('person_sequence'),
  login varchar(100) not null,
  firstname varchar(100),
  lastname varchar(100),
  active boolean,
  creator varchar(100) ,
  created timestamp ,
  modificator varchar(100),
  modified timestamp
);

