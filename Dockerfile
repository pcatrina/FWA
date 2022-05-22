FROM postgres
COPY src/main/resources/sql/schema.sql /docker-entrypoint-initdb.d