START TRANSACTION;

create index IX_ZIPCODE_INSEE
  on zipcode(city_insee);

create index IX_ZIPCODE_ZIPCODE
  on zipcode(code_postal);

create index IX_ZIPCODE_NAME
  on zipcode(nom);

create unique index UX_CITY
  on city(insee);

create index IX_CITY_DISTRICT
  on city(departement);

create index IX_CITY_REGION
  on city(region);

create unique index UX_REGION
  on region(region);

create unique index UX_DISTRICT
  on district(departement);

create index IX_DISTRICT_REGION
  on district(region);

create unique index UX_CODE_FAMILLE
  on code(famille, code);

create unique index UX_TYPE_NOM
  on type_nom(type_nom, uppercase);

COMMIT;
END TRANSACTION;
