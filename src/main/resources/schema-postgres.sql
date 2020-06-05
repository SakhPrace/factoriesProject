CREATE SCHEMA if not exists public;
CREATE TABLE IF NOT EXISTS factory (
id serial PRIMARY KEY,
name VARCHAR(255),
exportid integer,
password VARCHAR
);
CREATE TABLE IF NOT EXISTS product (
id serial PRIMARY KEY,
name VARCHAR(255),
price_per_unit integer
);
CREATE TABLE IF NOT EXISTS transport_operator (
id serial PRIMARY KEY,
name VARCHAR(255),
price_per_unit integer,
password VARCHAR
);
CREATE TABLE IF NOT EXISTS ordering (
id serial PRIMARY KEY,
id_factory integer,
id_product integer,
id_transport integer,
price integer
);
CREATE TABLE IF NOT EXISTS auction (
id serial PRIMARY KEY,
id_order integer,
offered_price integer,
id_transporter integer
);

CREATE TABLE IF NOT EXISTS factory_product (
    factory_id INT PRIMARY KEY,
    product_id INT,
    FOREIGN KEY (factory_id) REFERENCES factory(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);