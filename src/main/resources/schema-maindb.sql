CREATE SCHEMA if not exists public;
CREATE DATABASE if not exists maindb;
CREATE TABLE IF NOT EXISTS factory (
id integer not null AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255),
exportid integer,
password VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS product (
id integer not null AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255),
price_per_unit integer
);
CREATE TABLE IF NOT EXISTS transport_operator (
id integer not null AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255),
price_per_unit integer,
password VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS ordering (
id integer not null AUTO_INCREMENT PRIMARY KEY,
id_factory integer,
id_product integer,
id_transport integer,
price integer,
FOREIGN KEY (id_factory) REFERENCES factory(id),
FOREIGN KEY (id_product) REFERENCES product(id),
FOREIGN KEY (id_transport) REFERENCES transport_operator(id)
);
CREATE TABLE IF NOT EXISTS auction (
id integer not null AUTO_INCREMENT PRIMARY KEY,
id_order integer UNIQUE not null ,
offered_price integer,
id_transporter integer,
FOREIGN KEY (id_order) REFERENCES ordering(id),
FOREIGN KEY (id_transporter) REFERENCES transport_operator(id)
);

CREATE TABLE IF NOT EXISTS factory_product (
factory_id INT PRIMARY KEY,
product_id INT,
FOREIGN KEY (factory_id) REFERENCES factory(id),
FOREIGN KEY (product_id) REFERENCES product(id)
);

/* INSTALL SONAME 'ha_oqgraph';
CREATE TABLE IF NOT EXISTS oq2_backing (
origid INT UNSIGNED NOT NULL,
destid INT UNSIGNED NOT NULL,
weight DOUBLE NOT NULL,
PRIMARY KEY (origid, destid),
KEY (destid)
);


CREATE TABLE oq2_graph (
latch VARCHAR(32) NULL,
origid BIGINT UNSIGNED NULL,
destid BIGINT UNSIGNED NULL,
weight DOUBLE NULL,
seq BIGINT UNSIGNED NULL,
linkid BIGINT UNSIGNED NULL,
KEY (latch, origid, destid) USING HASH,
KEY (latch, destid, origid) USING HASH
)

ENGINE=OQGRAPH
data_table='oq2_backing' origid='origid' destid='destid' weight='weight'; */