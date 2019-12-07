FROM postgres:latest

COPY sql/*.sql setup.sh /docker-entrypoint-initdb.d/
COPY data/* /data/
COPY setup/* /data/

