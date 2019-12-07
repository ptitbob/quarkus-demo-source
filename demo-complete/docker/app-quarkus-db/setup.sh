#!/bin/bash

# psql -U postgres -c "COPY zipcode FROM '/data/cities.csv' DELIMITER ';' CSV;"

psql -U postgres -a -f /data/zipcode.sql
psql -U postgres -a -f /data/city.sql
psql -U postgres -a -f /data/district.sql
psql -U postgres -a -f /data/region.sql
