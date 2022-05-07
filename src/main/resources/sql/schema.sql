CREATE SCHEMA IF NOT EXISTS fwa_schema;

CREATE TABLE IF NOT EXISTS fwa_schema.users (
    user_id serial PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL ,
    phone VARCHAR(10) NOT NULL,
    password VARCHAR(255) NOT NULL
);