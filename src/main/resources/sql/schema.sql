CREATE SCHEMA IF NOT EXISTS fwa_schema;

CREATE TABLE IF NOT EXISTS fwa_schema.users
(
    user_id    serial PRIMARY KEY,
    image_id   BIGINT,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    phone      VARCHAR(10)  NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS fwa_schema.images
(
    image_id  serial PRIMARY KEY,
    user_id   BIGINT REFERENCES fwa_schema.users (user_id) ON DELETE CASCADE,
    size      BIGINT       NOT NULL,
    file_name VARCHAR(255) NOT NULL,
    mime      VARCHAR(20)   NOT NULL,
    date      TIMESTAMP    NOT NULL
);

CREATE TABLE IF NOT EXISTS fwa_schema.connection_logs
(
    object_id   serial PRIMARY KEY,
    user_id     BIGINT REFERENCES fwa_schema.users (user_id),
    date        TIMESTAMP NOT NULL,
    ip          VARCHAR(15) NOT NULL
);