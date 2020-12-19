CREATE DATABASE university_system ENCODING 'UTF-8';

CREATE TABLE user_types (
    id   SERIAL PRIMARY KEY,
    role VARCHAR(20)
);

INSERT INTO user_types (id, role) VALUES
    (DEFAULT, 'student'),
    (DEFAULT, 'admin');

CREATE TABLE users (
    id       SERIAL PRIMARY KEY,
    password VARCHAR(50) UNIQUE NOT NULL,
    role     INTEGER NOT NULL,
    FOREIGN KEY (role) REFERENCES user_types (id)
);

INSERT INTO users (id, password, role) VALUES
    (DEFAULT, '123', 1),
    (DEFAULT, '1234', 2);

SELECT * from users;