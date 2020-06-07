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

CREATE TABLE IF NOT EXISTS factory_product (
factory_id INT PRIMARY KEY,
product_id INT,
FOREIGN KEY (factory_id) REFERENCES factory(id),
FOREIGN KEY (product_id) REFERENCES product(id)
);
CREATE TABLE IF NOT EXISTS auction (
id integer not null AUTO_INCREMENT PRIMARY KEY,
id_order integer UNIQUE not null ,
offered_price integer,
id_transporter integer,
FOREIGN KEY (id_order) REFERENCES ordering(id),
FOREIGN KEY (id_transporter) REFERENCES transport_operator(id)
);
CREATE TABLE IF NOT EXISTS order_auction (
order_id INT PRIMARY KEY,
auction_id INT,
FOREIGN KEY (order_id) REFERENCES factory(id),
FOREIGN KEY (auction_id) REFERENCES auction(id)
);
CREATE TABLE IF NOT EXISTS transporter_auction (
transporter_id INT PRIMARY KEY,
auction_id INT,
FOREIGN KEY (transporter_id) REFERENCES transport_operator(id),
FOREIGN KEY (auction_id) REFERENCES auction(id)
);

CREATE TABLE IF NOT EXISTS roads_backing (
origid INT UNSIGNED NOT NULL,
destid INT UNSIGNED NOT NULL,
weight DOUBLE NOT NULL,
PRIMARY KEY (origid, destid),
KEY (destid)
);

DELETE FROM maindb.roads_backing;
INSERT INTO roads_backing(origid, destid, weight) VALUES (1,2,1), (2,3,3), (3,4,2), (4,5,3), (2,4,8), (2,5,7),(3,5,1),(2,1,1), (3,2,3), (4,3,2), (5,4,3), (4,2,8), (5,2,7),(5,3,1);

CREATE TABLE IF NOT EXISTS roads_graph (
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
data_table='roads_backing' origid='origid' destid='destid' weight='weight';

SET @optimal_path:=(SELECT GROUP_CONCAT(linkid ORDER BY seq) AS path FROM roads_graph
WHERE latch='dijkstras' AND origid=1 AND destid=5);