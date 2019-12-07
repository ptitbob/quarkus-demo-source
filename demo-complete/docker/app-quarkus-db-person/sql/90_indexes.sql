START TRANSACTION;

create unique index UX_PERSON
  on person(login);

COMMIT;
END TRANSACTION;
