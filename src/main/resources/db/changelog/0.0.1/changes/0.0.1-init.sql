CREATE SCHEMA IF NOT EXISTS users
CREATE TABLE IF NOT EXISTS users.users
(
    id        uuid not null
    constraint users_pkey primary key,
    first_name varchar,
    last_name  varchar
);