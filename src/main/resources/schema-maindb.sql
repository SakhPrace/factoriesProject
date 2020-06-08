CREATE SCHEMA if not exists public;
CREATE DATABASE if not exists maindb;

CREATE TABLE IF NOT EXISTS product (
id int not null AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255),
price_per_unit int
);

CREATE TABLE IF NOT EXISTS factory (
id int not null AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255),
exportid int,
password VARCHAR(255),
FOREIGN KEY (exportid) REFERENCES product(id)
);

CREATE TABLE IF NOT EXISTS transporter (
id int not null AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255),
price_per_unit integer,
password VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS ordering (
id int not null AUTO_INCREMENT PRIMARY KEY,
id_factory int,
id_product int,
id_transport int,
price int,
accepted boolean,
FOREIGN KEY (id_factory) REFERENCES factory(id),
FOREIGN KEY (id_product) REFERENCES product(id),
FOREIGN KEY (id_transport) REFERENCES transporter(id)
);

CREATE TABLE IF NOT EXISTS roads_backing (
origid INT UNSIGNED NOT NULL,
destid INT UNSIGNED NOT NULL,
weight DOUBLE NOT NULL,
PRIMARY KEY (origid, destid),
KEY (destid)
);

/*DELETE FROM maindb.roads_backing;
INSERT INTO roads_backing(origid, destid, weight) VALUES (1,2,1), (2,3,3), (3,4,2), (4,5,3), (2,4,8), (2,5,7),(3,5,1),(2,1,1), (3,2,3), (4,3,2), (5,4,3), (4,2,8), (5,2,7),(5,3,1);
*/

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