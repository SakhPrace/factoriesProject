CREATE SCHEMA if not exists public;
CREATE TABLE IF NOT EXISTS factory(id serial PRIMARY KEY, name VARCHAR(255), exportid integer);